/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

/**
 * Algorithm from http://www.mathblog.dk/project-euler-49-arithmetic-sequences-primes-permutations/
 */
object Problem049 {

  def digits(n: Int) = n.toString.toList.map(c => c.asDigit)
  
  def arePermutations(first: Int, second: Int) = {
    digits(second).permutations.contains(digits(first))
  }
  
  def findTuples(primes: Stream[Int]) = {
    for (i <- primes;
           j <- primes.filter(_ > i);
           k = j + (j-i);
           if Primes.isPrime(k);
           if arePermutations(i,j);
           if arePermutations(j,k)
    ) yield (i,j,k)
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val tuples = findTuples(Primes.primes.takeWhile(_ < 10000).filter(_ > 1000))
    tuples.foreach(println(_))
  }

}
