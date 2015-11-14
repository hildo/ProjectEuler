/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.csea.projecteuler

object Problem042 {

  def chars = List('.', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

  def getWordValue(word: String) = word.toList.map(_.toUpper).map(chars.indexOf(_)).sum
  
  def triangleNumbersStream(n: Int): Stream[Int] =  ((n * (n+1)) / 2 ) #:: triangleNumbersStream(n+1)
  val triangleNumbers = triangleNumbersStream(1)
  
  val words = {
    io.Source.fromInputStream(getClass.getResourceAsStream("/p042_words.txt")).getLines.next.split(",").map(_.replaceAll("\"",""))
  }
  
  def isTriangleWord(word: String) = {
    val wordValue = getWordValue(word)
    triangleNumbers.takeWhile(_ <= wordValue).contains(wordValue)
  }
  
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
      val triangleWords = for (word <- words;  if isTriangleWord(word)) yield word
      Console.println(triangleWords.size) // 162
  }

}
