package BankingApp

import scala.Console.{BOLD, RESET, UNDERLINED}
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readDouble, readInt, readLine}

class InvalidDepositException (s:String) extends Exception{
  override def toString: String = super.toString+"Invalid Deposit amount, exception caused: "+s
}
class InvalidSelectionException(s:String) extends Exception {
  override def toString: String = super.toString + "User's selection was invalid, exception caused: "
}
class InvalidACNException (s:String) extends Exception {
  override def toString: String = super.toString+"That ACN doesn't exist, exception caused: "+s
}
class InvalidPasswordException (s:String) extends Exception {
  override def toString: String = super.toString+"You don't work here!, exception caused: "+s
}

object Bank {
  def main(args: Array[String]): Unit = {
    val acc = new Account()
    val crd = new CreditCard()
    val che = new Cheque
    val sys = new System
    println(s"Welcome to ${BOLD}The Bank${RESET}. Please select from the choices below:")
    println(s"${BOLD}1)${RESET} ${UNDERLINED}Account Details${RESET} \n${BOLD}2)${RESET} ${UNDERLINED}Credit Card Enquiries${RESET} \n${BOLD}3)${RESET} ${UNDERLINED}Deposit Cheque${RESET} \n${BOLD}4)${RESET} ${UNDERLINED}Set up a New Account with Us!${RESET}\n${BOLD}5)${RESET} ${UNDERLINED}Admin Login${RESET}")

    var selection: Int = readInt()
    if (selection == 1) {
      println(s"${BOLD}Account Details${RESET}\nPress 1 to View Your account\nPress 2 to Add Money to your Account\nPress 3 to Withdraw money from your account\nPress 4 to Set up an Account with Us!\nPress 5 for Admin settings")
      selection = readInt()
      if (selection == 1) {
        acc.userDetails()
      } else if (selection == 2) {
        acc.addFundsLogin()
      } else if (selection == 3) {
        acc.withdrawFundsLogin()
      } else {
        System.err.println("Invalid selection")
      }
    } else if (selection == 2) {
      crd.userDetails()
    } else if (selection == 3) {
      che.userDetails()
    } else if (selection == 4) {
      acc.accCreation()
    } else if (selection == 5) {
      sys.overview()
      println(s"Choose your option:\n1)View all cheques cashed to date\n2)View our total number of customers\n3)View details of all customers\nPress 4 to Delete an Account.")
      selection = readInt()
      if (selection == 1) {
        sys.viewCheques()
      } else if (selection == 2) {
        sys.viewCustomers()
      } else if (selection == 3) {
        sys.viewAll()
      } else if (selection == 4) {
        acc.accDeletion()
      } else {
        System.err.println("Invalid selection")
      }
    } else {
      System.err.println("Invalid selection")
    }
  }
}


