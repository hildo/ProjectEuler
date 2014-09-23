/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

object Problem017 {

  val onesMap = Map[Int, String](1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five", 6 -> "six",
    7 -> "seven", 8 -> "eight", 9 -> "nine")
  val firstTensMap  = Map[Int, String](0 -> "ten", 1 -> "eleven",  2 -> "twelve", 3 -> "thirteen", 4 -> "fourteen", 5 -> "fifteen",
    6 -> "sixteen", 7 -> "seventeen", 8 -> "eighteen", 9 -> "nineteen")
  val tensMap = Map[Int, String] (2 -> "twenty", 3 -> "thirty", 4 -> "forty", 5 -> "fifty", 6 -> "sixty", 7 -> "seventy",
    8 -> "eighty", 9 -> "ninety")
  val hundredsMap = Map[Int, String] (1 -> "one hundred", 2 -> "two hundred", 3 -> "three hundred", 4 -> "four hundred", 5 -> "five hundred", 6 -> "six hundred", 7 -> "seven hundred",
    8 -> "eight hundred", 9 -> "nine hundred")

  def writeOneDigitNumber(input: Int): String = {
    onesMap.get(input).get
  }

  def writeTwoDigitNumber(digits: IndexedSeq[Int]): String = {
    if (digits.apply(0) == 0) writeOneDigitNumber(digits.apply(1))
    else if (digits.apply(0) == 1) firstTensMap.get(digits.apply(1)).get
    else if (digits.apply(1) == 0) tensMap.get(digits.apply(0)).get
    else tensMap.get(digits.apply(0)).get + "-" + onesMap.get(digits.apply(1)).get
  }

  def writeThreeDigitNumber(digits:IndexedSeq[Int]): String = {
    if (digits.apply(1) == 0 && digits.apply(2) == 0) hundredsMap.get(digits.apply(0)).get
    else hundredsMap.get(digits.apply(0)).get + " and " + writeTwoDigitNumber(digits.drop(1))
  }

  def writeNum(input: Int): String = {
    if (input == 1000) "one thousand"
    else {
      val digitList = input.toString.map(_.asDigit)
      digitList.length match {
        case 1 => writeOneDigitNumber(digitList.apply(0))
        case 2 => writeTwoDigitNumber(digitList)
        case 3 => writeThreeDigitNumber(digitList)
        case _ => "None"
      }
    }
  }

  def numChars(input: String): Int = {
    input.filter(_ != '-').filter(_ != ' ').length
  }

  def count = {
    println(Range.apply(1, 1001).map(writeNum(_)).map(numChars(_)).sum)
  }
}
