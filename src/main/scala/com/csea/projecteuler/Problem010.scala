/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem010 {

//  def primes: Stream[Long] = 2 #:: prime3

  // performance: avoid redundant divide by two, so this starts at 3
  private val prime3: Stream[Long] = {
    def next(i: Long): Stream[Long] =
      if (prime(i))
        i #:: next(i + 2)
      else
        next(i + 2) // tail
    3 #:: next(5)
  }

  // assumes not even, check evenness before calling - perf note: must pass partially applied >= method
  private def prime(i: Long) =
    prime3 takeWhile (math.sqrt(i).>= _) forall { i % _ != 0 }


  def getSum(): Long = {
    primes.takeWhile(_ < 2000000).sum
  }


  def from(n: Int) : Stream[Int] = n #:: from(n+1)
  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
  val primes = sieve(from(2)) // This is a Stream of Prime Numbers
}
