/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem026 {

  private val TEN: BigDecimal = 10
  
  def from(n: Int): Stream[Int] = n #:: from(n+1)
  val nats = from(1)
  
  def recurringCycleLength(n: Int) = {
    if (FindPrimes.isPrime(n)) {
      nats.find(i => (TEN.pow(i) - 1) % n == 0 ).get
    } else {
      0
    }
  }
  
  def main(args: Array[String]): Unit = {
    println(List.range(6,1000).zipWithIndex.map(tuple => (recurringCycleLength(tuple._1), tuple._1)).maxBy(tuple => tuple._1))  
  }

}
