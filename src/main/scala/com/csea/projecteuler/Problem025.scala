/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem025 {

  lazy val fib: Stream[Int] = Stream.cons(0, Stream.cons(1, fib.zip(fib.tail) map { case (c1,c2) => c1 + c2 } ))

}
