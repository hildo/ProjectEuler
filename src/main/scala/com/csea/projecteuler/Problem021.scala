/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem021 {

  def divisors(n: Int): List[Int] = 
    for (i <- List.range(1, n-1) if n % i == 0) yield i
  
  def amicableNumber(a: Int) = {
    val b = divisors(a).sum //d(a) = b
    val a2 = divisors(b).sum // d(b) = a
    ((a2 != b) && (a == a2))
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println((for (i <- List.range(1, 9999) if amicableNumber(i)) yield i).sum)
  }

}
