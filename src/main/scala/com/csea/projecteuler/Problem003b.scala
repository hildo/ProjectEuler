/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

import Math.{floor,sqrt}

object Problem003b {

 def findGPF(number: Long, divisor: Long):Long = {
    divisor match {
      case x if x > floor(sqrt(number)) => number
      case x if number%x == 0 && x > 1 => findGPF(number/x, x)
      case _ => findGPF(number, divisor+1)
    }
  }
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println(findGPF(600851475143L, 1))
  }

}
