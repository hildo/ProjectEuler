/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler


// A Point is the index of the array containing the point, plus the position in the array
class Point(val arrayIndex: Int, val positionInArray: Int)

class Path(val points: List[Point], pointValues: Array[Array[Int]]) {
  override def toString = {
    val builder: StringBuilder = new StringBuilder
    builder.append("[")
    for (point <- points) {
      builder.append("<")
      builder.append(point.arrayIndex)
      builder.append(",")
      builder.append(point.positionInArray)
      builder.append(">")
    }
    builder.append(",")
    builder.append(pathValue)
    builder.append("]")
    builder.toString
  }
  
  def pathValue = {
    points.foldLeft(0)((acc, p) => {
        val arr = pointValues(p.arrayIndex)
        acc + arr(p.positionInArray)
      })
  }
}

object Problem018 {

  val valueArrays:Array[Array[Int]] = {
    io.Source.fromInputStream(getClass.getResourceAsStream("/smallTriangle.txt")).getLines.toArray.map(_.split(" ").map(_.toInt))
  }

  def nextValue(input: Array[Int], index: Int) : (Int, Int) = {
    if (input.length == 1) {
      (0, input(0))
    } else {
      val value1 = input(index)
      val value2 = input(index+1)
      if (value1 >= value2) {
        (index, value1)
      } else {
        (index+1, value2)
      }
    }
  }
  
  def printArrays = {
    for (intArray <- valueArrays) {
      print("[")
      for (value <- intArray) {
        print(value)
        print(",")
      }
      print("]\n")
    }
  }
  
  def buildPossiblePaths(path: Path): List[Path] = {
    val lastPoint = path.points.head
    val leftPoint = new Point(lastPoint.arrayIndex + 1, lastPoint.positionInArray)
    val rightPoint = new Point(lastPoint.arrayIndex + 1, lastPoint.positionInArray + 1)
    val leftPath = new Path(leftPoint :: path.points, valueArrays)
    val rightPath = new Path(rightPoint :: path.points, valueArrays)
    List(leftPath, rightPath)
  }
  
  def buildPossiblePaths(paths: List[Path]): List[Path] = {
    var returnValue = List[Path]()
    for (path <- paths) {
      val newPaths = buildPossiblePaths(path)
      returnValue = returnValue ::: newPaths
    }
    returnValue
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    var nextPaths = buildPossiblePaths(List(new Path(List(new Point(0,0)), valueArrays)))
    var lastPoint = nextPaths.head.points.head
    while (lastPoint.arrayIndex < valueArrays.length - 1) {
      nextPaths = buildPossiblePaths(nextPaths)
      lastPoint = nextPaths.head.points.head
    }
    
    println(nextPaths.maxBy(_.pathValue).toString)
  }

}
