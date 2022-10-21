package BankingApp

import scala.Console.{BOLD, RESET}
import scala.io.StdIn.{readDouble, readInt, readLine}
import BankingApp.chequesCashed

class Cheque extends Account{
  override def userDetails(): Unit = {
    println("Please enter your account number")
    val accNum5 = readInt()
    if (accNum5.toString.length == 8) {
      addCheque(accNum5)
    } else {
      println("Invalid Account Number")
    }
  }
  def addCheque(aNum: Int): Unit = {
    println(s"Which Bank is this cheque from? Our accepted banks are ${BOLD}Natwest, Barclays, HSBC and Bank of America${RESET}")
    val checkCheque1 = readLine()
    if (checkCheque1 == "Natwest" || checkCheque1 == "Barclays" || checkCheque1 == "HSBC" || checkCheque1 == "Bank of America") {
      println(s"How much will you be depositing with this cheque? Our limit is £10,000,000.00")
      val checkCheque2:Double = readDouble()
      if (checkCheque2 > 0.00 && checkCheque2 < 10000000.00) {
        println(s"Please enter the Cheque number below: ")
        val checkCheque3:Int = readInt()
        if (checkCheque3.toString.length == 6) {
          println("This information CHEQUES out, it will be processed by the next working day")
          chequesCashed += 1
          BankingApp.hello()
        }
        else {
          throw new InvalidSelectionException("Invalid Cheque Number!")
        }
      }
      else {
        throw new InvalidDepositException("Can't deposit that amount!")
      }
    }
    throw new InvalidSelectionException("This Bank's cheques are not accepted here!")
  }
}
