/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem005 {

  lazy val naturals: Stream[Int] = Stream.cons(2520, naturals.map(_ + 2520))

  def main(args: Array[String]): Unit = {
    println(naturals.find(i => List.range(11, 20).forall(j => i % j == 0)).get)
  }

}
