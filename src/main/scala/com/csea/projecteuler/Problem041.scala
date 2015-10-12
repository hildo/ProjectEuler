/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem041 {

  def from(n: Int): Stream[Int] = n #:: from(n+1)
  val nats = from(0)
  
  def isPandigital(number:Int) = {
    val digits = number.toString.toList.map(c => c.asDigit)
    !(digits.contains(0)) && (digits.max == digits.length) && (digits.distinct.length == digits.length)
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    var maxPandigital = 0
    val iter = nats.iterator
    var value = iter.next
    while (value <= 80000000) {
      if (isPandigital(value) && Primes.isPrime(value)) {
        maxPandigital = value
        Console.println("new max => " + value)
      }
      value = iter.next
    }
    Console.println("max is " + maxPandigital)
    // Answer is 7652413
  }

}
