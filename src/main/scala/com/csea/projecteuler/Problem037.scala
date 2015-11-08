/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem037 {

  def truncateRight(input: Int) : Option[Int] = input.toString.length match {
    case 1 => None
    case y: Int => Some(input.toString.substring(0, y-1).toInt)
  }

    def truncateLeft(input: Int) : Option[Int] = input.toString.length match {
    case 1 => None
    case y: Int => Some(input.toString.substring(1).toInt)
  }

  def isTruncatable(input: Int) = {
    var returnValue = false;
    var valueOpt = truncateRight(input)
    while (valueOpt.isDefined) {
      returnValue = Primes.isPrime(valueOpt.get)
      returnValue match {
        case true => valueOpt = truncateRight(valueOpt.get)
        case false => valueOpt = None
      }
    }
    
    if (returnValue) {
      valueOpt = truncateLeft(input)
      while (valueOpt.isDefined) {
        returnValue = Primes.isPrime(valueOpt.get)
        returnValue match {
          case true => valueOpt = truncateLeft(valueOpt.get)
          case false => valueOpt = None
        }
      }
    }
    returnValue
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    isTruncatable(8920)
    isTruncatable(3797)
    val tprimes = for (i <- List.range(8, 1000000); if Primes.isPrime(i); if isTruncatable(i)) yield i
    Console.println("# of truncatable primes: " + tprimes.size)
    tprimes.foreach(v => Console.println(v))
    Console.println("Sum of primes = " + tprimes.sum) //748317
  }

}
