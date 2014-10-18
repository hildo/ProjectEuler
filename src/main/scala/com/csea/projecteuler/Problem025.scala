/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

import scala.math.BigInt

object Problem025 {

  val fibs: Stream[BigInt] = BigInt(1) #:: BigInt(1) #:: fibs.zip(fibs.tail).map(n => n._1 + n._2)

  def main(args: Array[String]): Unit = {
    println(fibs.indexWhere(n => n.toString.length == 1000) + 1)
    // Index is 4781, but the index is zero based, so answer is 4782
  }

}
