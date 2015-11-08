/*
 * From http://louisbotterill.blogspot.com.au/2009/01/scala-example-finding-prime-numbers.html
 * http://louisbotterill.blogspot.com.au/2009/07/scala-lazy-evaluation-and-sieve-of.html
 */

package com.csea.projecteuler

object Primes {

  def isPrime(n : Int) : Boolean = n match {
    case 0 => false
    case 1 => false
    case _ => n == smallestDivisor(n)
  }

  def smallestDivisor(n : Int) : Int = {
    findDivisor(n, 2)
  }

  def findDivisor(n : Int, testDivisor : Int) : Int = {
    if (square(testDivisor) > n)
      n
    else if (divides(testDivisor, n))
      testDivisor
    else
      findDivisor(n, testDivisor + 1)
  }

  def square(n : Int) : Int = n * n

  def divides(d : Int, n : Int) : Boolean = (n % d) == 0

  def from(n: Int) : Stream[Int] = n #:: from(n+1)
  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
  def primes = sieve(from(2)) // This is a Stream of Prime Numbers
  
  def getPrimesLessThan(upperLimit: Int) = {
    primes.takeWhile(n => n < upperLimit)
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    for (n <- 1 to 500) {

      val d = smallestDivisor(n)
      println(n + ": lcd = " + d + (if (n == d) " prime!" else " not prime") )
    }
  }

}
