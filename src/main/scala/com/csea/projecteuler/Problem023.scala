/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem023 {

  def divisors(n: Int): List[Int] = 
    for (i <- List.range(1, n-1) if n % i == 0) yield i

  def isAbundant(n: Int): Boolean = divisors(n).sum > n
    
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val abundantNums = for (i <- List.range(1, 28123) if isAbundant(i)) yield i
    println(abundantNums.toString)
  }

}
