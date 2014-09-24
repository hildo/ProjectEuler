/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem009 {

  def pythTriple(n: Int) = ((2 * n) + 1, 2 * n * (n + 1), 2 * n * (n + 1) + 1)

  def pythTriple2(n: Int) = {
    if (n %2 == 0) {
      val b = ((n ^ 2) / 4) - 1
      (n, b, b + 2)
    } else {
      val b = ((n ^ 2) / 2) - (1/2)
      (n, b, b + 1)
    }
  }

  def pythTriple3(a: Int) = (a, ((a ^ 2) - 1) / 2, ((a ^ 2) + 1) / 2)

  def findSum(total: Int) = {
    def innerSum(seed: Int): (Int, Int, Int) = {
//      val triple = pythTriple(seed)
//      val triple = pythTriple2(seed)
      val triple = pythTriple3(seed)
      val t = triple._1 + triple._2 + triple._3
      println(seed + " -> " + triple + " -> " + t)
      if (t == total)
        triple
      else if (t < total)
        innerSum(seed+2)
      else
        (0,0,0)
    }
    innerSum(3)
  }

}
