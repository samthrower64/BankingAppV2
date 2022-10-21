package BankingApp

import scala.io.StdIn.{readInt, readLine}
import BankingApp.{accNum, accType, adminPwd, chequesCashed, name, totalCustomers}

import scala.Console.{BOLD, RESET, UNDERLINED}
class System extends Account {
  def overview(): Unit = {
    println("Enter Administrator Password")
    var x = readLine()
    if (x == adminPwd) {
      println("Good to see you again, Mr CEO.")
      println(s"${BOLD}1)${RESET} ${UNDERLINED}Check amount of Cheques cashed to date.${RESET} \n${BOLD}2)${RESET} ${UNDERLINED}View number of customers${RESET} \n${BOLD}3)${RESET} ${UNDERLINED}View all customer details${RESET}")
      var adminSelect = readInt()
      adminSelect match {
        case 1 => viewCheques(); println("\n\n"); overview()
        case 2 => viewCustomers(); println("\n\n");overview()
        case 3 => viewAll(); println("\n\n");overview()
        case _ => returner()
      }
    }
    else{
      throw new InvalidPasswordException("You don't work here! Get out!!")
    }
  }
  def viewCheques(): Unit = {
    print(s"Customers have deposited a total of: $chequesCashed cheques")
  }
  def viewCustomers(): Unit = {
    print(s"We have a total of: $totalCustomers currently registered with our bank")
  }
  def viewAll(): Unit = {
    println("Customers: " + name.foreach(println))
    println("Account Numbers: " + accNum.foreach(println))
    println("Their Account Types: " + accType.foreach(println))
    println("Their Current Balances are: " + name.foreach(println))
  }
}
