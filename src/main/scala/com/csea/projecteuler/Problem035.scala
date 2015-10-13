/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem035 {

  def rotatedValues(input: Int) = {
    var rotatedValuesList = List(input)
    var digitList = input.toString.toList.map(c => c.asDigit)
    var nextRotation = true
    while (nextRotation) {
      digitList = digitList.tail :+ digitList.head
      var rotatedValue = digitList.map(i => i.toString).mkString.toInt
      if (rotatedValue != input) {
        rotatedValuesList = rotatedValuesList :+ rotatedValue
        nextRotation = true
      } else {
        nextRotation = false
      }
    }
    rotatedValuesList
  }
  
  def isCircularPrime(input: Int) = rotatedValues(input).foldLeft(true)((track, value) => track && Primes.isPrime(value))
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val values = for (i <- List.range(2, 1000000);
                                  if isCircularPrime(i)
                                ) yield i
    Console.println("values length: " + values.size)
    // answer: 55
  }

}
