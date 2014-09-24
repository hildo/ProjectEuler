/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

class Grid(xLimit: Int, yLimit: Int) {

  type Point = (Int, Int)
  type Path = (Point, Int)

  def targetReached(point: Point): Boolean = {
      point match {
        case (x, y) => x == xLimit && y == yLimit
      }
  }

  def nextSteps(point: Point): List[Point] = {
    if (point._1 == xLimit) List((point._1, point._2 + 1))
    else if (point._2 == yLimit) List((point._1 + 1, point._2))
    else List((point._1 + 1, point._2), (point._1, point._2 + 1))
  }

  def constructPaths(path: Path): List[Path] = {
    val step = path._1
    if (targetReached(step)) List(path)
    else {
        for {
          nextStep <- nextSteps(step)
        } yield (nextStep, path._2 + 1)
    }
  }

  def allPaths: Vector[Path] = {
    def buildAllPaths(accum: Vector[Path]): Vector[Path] = {
      println("accum.length=" + accum.length)
      val newPaths =
        for {
          path <- accum
          newPath <- constructPaths(path)
        } yield newPath
//      if (newPaths.forall(p => targetReached(p._1))) newPaths
//      else buildAllPaths(newPaths)
      if (targetReached(newPaths.head._1)) newPaths
      else buildAllPaths(newPaths)
    }
    val start = (0,0)
    buildAllPaths(Vector((start,0)))
  }

//  type Path = List[Point]
//  def constructPaths(path: Path): List[Path] = {
//    val step = path.head
//    if (targetReached(step)) List(path)
//    else {
//        for {
//          nextStep <- nextSteps(step)
//        } yield nextStep :: path
//    }
//  }
//
//  def allPaths: List[Path] = {
//    def buildAllPaths(accum: List[Path]): List[Path] = {
//      val newPaths =
//        for {
//          path <- accum
//          newPath <- constructPaths(path)
//        } yield newPath
//      if (newPaths.forall(p => targetReached(p.head))) newPaths
//      else buildAllPaths(newPaths)
//    }
//    val start = (0,0)
//    buildAllPaths(List(List(start)))
//  }

}



