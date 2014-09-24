/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem012 {
  val triangleNumbers: Stream[Int] = {
    def defineTri(idx: Int, priorValue: Int): Stream[Int] = idx match {
      case 1 => 1 #:: defineTri(2, 1)
      case _ => {
          val rv = priorValue + idx
           rv #:: defineTri(idx + 1, rv)
      }
    }
    defineTri(1, 0)
  }

  // Got this function from http://rosettacode.org/wiki/Factors_of_an_integer#Scala
  def factors(n: Int) = Range.apply(1, scala.math.sqrt(n).toInt).filter(n % _ == 0).flatMap(x => List(n/x,x)).toList.sortWith(_ > _)

  def getNum(): Int = {
    triangleNumbers.dropWhile(factors(_).length < 501).head
  }
}
