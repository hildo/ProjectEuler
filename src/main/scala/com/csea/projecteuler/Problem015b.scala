/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem015b {

  def shiftRight(row: List[BigInt]): List[BigInt] = 0::row
  def shiftLeft(row: List[BigInt]): List[BigInt] = row:::List(BigInt(0))

  def addList(l1: List[BigInt], l2: List[BigInt]): List[BigInt] = (l1, l2) match {
    case (_, Nil) => Nil
    case (Nil, _) => Nil
    case (h1::t1, h2::t2) => (h1 + h2)::addList(t1, t2)
  }

  def pascalStream(row: List[BigInt]): Stream[List[BigInt]] =
    Stream.cons(row, pascalStream(addList(shiftLeft(row), shiftRight(row))))

  val lazyTriangle = pascalStream(List(BigInt(1)))
}
