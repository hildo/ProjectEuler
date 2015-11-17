/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem045 {

  def pentagonalNum(n: BigInt): BigInt = ((n) * ((3 * n) - 1))/ 2
  
  def hexagonalNum(n: BigInt): BigInt = ((n) * ((2 * n) - 1))
    
  def pentNumStream(n: BigInt): Stream[BigInt] = pentagonalNum(n) #:: pentNumStream(n+1)
  val pentNums = pentNumStream(2)
  
  def hexNumStream(n: BigInt) : Stream[BigInt] = hexagonalNum(n) #:: hexNumStream(n + 1)
  val hexNums = hexNumStream(2)
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val nums = for (h <- hexNums.take(91000);
           if (pentNums.takeWhile(_ <= h).contains(h))
    ) yield h
    nums.take(2).foreach(println(_))
  }

}
