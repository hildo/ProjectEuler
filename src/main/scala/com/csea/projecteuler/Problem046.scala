/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem046 {

  def twiceASquare(n: Int) : Stream[Double] = (2 * scala.math.pow(n.doubleValue,2)) #::twiceASquare(n+1)
  val squares = twiceASquare(1)
  
  def supportsGoldbachConjecture(n: Int) = {
    val candidatePrimes = Primes.primes.takeWhile(_ <= n)
    val possibleSums = for (p <- candidatePrimes;
                                             s <- squares.takeWhile(_ <= n - p)
                                      ) yield (p + s)
    possibleSums.contains(n)
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    Primes.composites.filter(_ % 2 != 0).find(!supportsGoldbachConjecture(_)).foreach(println(_))
  }

}
