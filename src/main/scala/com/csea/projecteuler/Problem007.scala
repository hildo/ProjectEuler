/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem007 {
  def primes : Stream[Int] = {

    def findNextPrime(primes: List[Int])={
      var i = primes.head+1
      while(primes.exists(x => i % x == 0)){i+=1}
      i
    }

    def prim(primes:List[Int]): Stream[Int] = primes match{
      case Nil => 1 #:: 2 #:: prim(List(2))
      case _ => {
        val next = findNextPrime(primes)
        next #:: prim(next::primes)
      }
    }

    prim(Nil)
  }

}
