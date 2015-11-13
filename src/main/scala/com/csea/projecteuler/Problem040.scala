/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem040 {

  def digitCount(n: Int) = n.toString.length
  
  def fstream(from: (Int, Int)): Stream[(Int, Int)] = from #:: fstream((from._1 + digitCount(from._2 + 1) ,from._2 + 1))
  val tupleStream = fstream((1,1))
  
  def numberAtDigit(digit: Int) = {    
    tupleStream.find(_._1 >= digit) match {
      case Some((size, number)) => size match {
          case `digit` => number.toString.map(_.asDigit).last
          case _ => number.toString.map(_.asDigit).apply(number.toString.length - (size - digit) -1)
      }
      case None => 0
    }
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    Console.println(List(1,10,100,1000,10000,100000,1000000).map(numberAtDigit(_)).product)  
  }

}
