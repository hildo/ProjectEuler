/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem009b {
  def gcd (a: Int, b: Int) : Int = if (a == b)
    a else
      if (a > b) gcd (a-b, b) else
        gcd (b, a)

  def gcd (a: Int, b: Int, c:Int): Int = gcd (c, gcd (a, b))

  def pythagorean (a: Int, b: Int, c: Int) = (a * a + b * b == c * c)

  def run {
    for (c <- (5 to 629);
      a <- (1 to c-2);
      b <- (a to c-1);
      if (pythagorean (a, b, c) && gcd (a, b, c) == 1) && (a + b + c == 1000)) yield {
        println (a + "² + "  + b + "² = " + c + "² => " + (a*a) + " + " + (b*b) + " = " + (c*c))
        c*c
      }
  }
}
