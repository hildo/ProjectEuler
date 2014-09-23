/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem004 {

  def isPalindrome(value: Int) : Boolean = {
    val s = value.toString
    s == s.reverse
  }

  def products(from: Int, to: Int) : List[Int] = {
    def buildProduct(acc: List[Int], x: Int, y: Int) : List[Int] = {
      if (y < to) buildProduct((x * y) :: acc, x, y + 1)
      else if (x < to) buildProduct(acc, x + 1, x + 1)
      else acc
    }
    buildProduct(List.empty, from, from)
  }

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println(products(100,1000).filter(isPalindrome).max)
  }

}
