/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler


case class Date(val day: Int, val month: Int, val year: Int) {
  override def toString = "[Date: " +  day + "/" + month + "/" + year + "]"

  def isLeapYear(year: Int) : Boolean = {
    if (year % 4 == 0) {
      if (year % 100 == 0) {
        year % 400 == 0
      } else {
        true
      }
    } else {
      false
    }
  }
  
  def maxDay(d: Date) = d.month match {
    case 2 => isLeapYear(d.year) match {
        case true => 29
        case false => 28
      }
    case 4 => 30
    case 6 => 30
    case 9 => 30
    case 11 => 30
    case _ => 31
  }
  
  def plusOneWeek: Date = {
    val newDay = day + 7
    val m = maxDay(this)
    if (newDay > maxDay(this)) {
      if (month == 12) {
        Date(newDay - m, 1, year + 1)
      } else {
        Date(newDay - m, month + 1, year)
      }
    } else {
      Date(newDay, month, year)
    }
  }
}

object Problem019 {
  
  val sundays: Stream[Date] = {
    def loop(d: Date): Stream[Date] = {
      d #:: loop(d.plusOneWeek)
    }
    loop(Date(31, 12, 1899))
  }

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    println(sundays.takeWhile(d => d.year < 2001).filter(d => d.year > 1900).filter(d => d.day == 1).toList.size)
    // Correct answer is 171
  }

}
