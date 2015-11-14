/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem039 {

  def solutions(perimeter: Int) = {
    for (a <- 1 to perimeter/3;
           b <- a + 1 to perimeter/2;
           c <- b + 1 to perimeter/2;
           if (a + b + c == perimeter);
           if (BigInt(a).pow(2) + BigInt(b).pow(2) == BigInt(c).pow(2))
      ) yield (a,b,c)
  }

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val perimeterTuples: IndexedSeq[(Int, IndexedSeq[(Int, Int, Int)])] = for (p <- 20 to 1000) yield (p, solutions(p))
    Console.println("Returned " + perimeterTuples.size + " tuples")
    val maxValue = perimeterTuples.maxBy(_._2.size)
    Console.println(maxValue)
    // Answer is 840, around 3 min to run
  }

}
