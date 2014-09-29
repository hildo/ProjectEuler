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
    val values1: Array[Int] = Array(75)
    val values2: Array[Int] = Array(95,64)
    val values3: Array[Int] = Array(17,47,82)
    val values4: Array[Int] = Array(18,35,87,10)
    val values5: Array[Int] = Array(20,4,82,47,65)
    val values6: Array[Int] = Array(19,1,23,75,3,34)
    val values7: Array[Int] = Array(88,2,77,73,7,63,67)
    val values8: Array[Int] = Array(99,65,4,28,6,16,70,92)
    val values9: Array[Int] = Array(41,41,26,56,83,40,80,70,33)
    val values10: Array[Int] = Array(41,48,72,33,47,32,37,16,94,29)
    val values11: Array[Int] = Array(53,71,44,65,25,43,91,52,97,51,14)
    val values12: Array[Int] = Array(70,11,33,28,77,73,17,78,39,68,17,57)
    val values13: Array[Int] = Array(91,71,52,38,17,14,91,43,58,50,27,29,48)
    val values14: Array[Int] = Array(63,66,4,68,89,53,67,30,73,16,69,87,40,31)
    val values15: Array[Int] = Array(4,62,98,27,23,9,70,98,73,93,38,53,60,4,23)
    Array(values1,values2,values3,values4,values5,
              values6,values7,values8,values9,values10,
              values11,values12,values13,values14,values15)
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
