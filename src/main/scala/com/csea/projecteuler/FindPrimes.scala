/*
 * From http://louisbotterill.blogspot.com.au/2009/01/scala-example-finding-prime-numbers.html
 */

package com.csea.projecteuler

object FindPrimes {

  def isPrime(n : Int) : Boolean = {

    n == smallestDivisor(n)
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

  def square(n : Int) : Int = {

    n * n
  }

  def divides(d : Int, n : Int) : Boolean = {

    (n % d) == 0
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
