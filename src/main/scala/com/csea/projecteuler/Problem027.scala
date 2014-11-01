/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem027 {

  val FORTY_SQUARED: Int = 40 * 40
  
  def quad(n: Int, a: Int, b: Int) = (n * n) + (a * n) + b
  
  def from(n: Int): Stream[Int] = n #:: from(n+1)
  val nats = from(0)
  
  def consecutivePrimes(a: Int, b: Int) = {
    nats.prefixLength(i => Primes.isPrime(quad(i, a, b)))
  }
  
  def includeNegation(ints: List[Int]) = ints.flatMap(n => List(n, -n))
  
  def main(args: Array[String]): Unit = {
    val tuples = for {
      a <- -999 to 999; b <- includeNegation(Primes.getPrimesLessThan(1000).toList)
      if (b > -(FORTY_SQUARED + (40 * a)))
      if (a % 2 != 0)
    } yield (a, b)
    val maxTuple = tuples.maxBy(t => consecutivePrimes(t._1, t._2))
    println(maxTuple._1 * maxTuple._2)
    // Answer should be -59231
  }

}
