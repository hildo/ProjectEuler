/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem020 {

  def factorial(n: Int): BigInt = if (n == 0) BigInt(1) else BigInt(n) * factorial(n-1)
  
  def sum(input: Int): Int = factorial(input).toString.map(_.asDigit).sum

}
