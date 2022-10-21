package BankingApp

import scala.io.StdIn.{readInt, readLine}

class CreditCard extends Account {
  override def userDetails(): Unit = {
    println("Please enter your account number")
    val accNum4 = readInt()
    if (accNum4.toString.length == 8) {
      newCard(accNum4)
    } else {
      println("Invalid Account Number")
    }
  }
  def newCard(aNum: Int): Unit = {
    println("Printing this new card will freeze your existing one.\nWould you like to go ahead with this? (Y/N)")
    var x = readLine()
    if (x == "Y") {
      println("A new card will be sent over 3-5 business days. Your current card has now been frozen")
    } else if (x == "N") {
      userDetails()
    }
    else {
      throw new InvalidSelectionException("Sorry, I didn't quite understand that selection. Remember, Capital Y or N!")
    }
  }
}
