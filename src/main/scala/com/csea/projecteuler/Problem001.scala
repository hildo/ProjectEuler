/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

/**
 * http://projecteuler.net/problem=1
 */
object Problem001 {

  def multiples (from:Int, to:Int): List[Int] =
    for (i <- List.range(from, to) if ((i % 3 == 0) || (i % 5 == 0))) yield i

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    Console.println(List.range(1,1000).filter(i => i % 3 == 0 || i % 5 == 0).sum)

    // or using the above mutiples function
    //Console.println(multiples(1,1000).sum)
    // or the foldLeft works as well
    // Console.println(multiples(1,1000).foldLeft(0)((i,s) => i + s))
  }

}
