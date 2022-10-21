package BankingApp

import scala.Console.{BOLD, RESET, UNDERLINED}
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readInt

object BankingApp extends App {
  var name: ListBuffer[String] = new ListBuffer[String]()
  name += ("Sam", "Joe")
  var accType: ListBuffer[String] = new ListBuffer[String]()
  accType += ("Standard  Account", "Savings Account")
  var accNum: ListBuffer[Int] = new ListBuffer[Int]()
  accNum += (77820001, 77820002)
  var bal: ListBuffer[Double] = new ListBuffer[Double]()
  bal += (2500.00, 4750.00)
  var interest: ListBuffer[Double] = new ListBuffer[Double]()
  interest += (0.75, 1.15)

  var adminPwd: String = "123abc"
  var chequesCashed = 0
  var totalCustomers = name.length
  var increment: Int = accNum((accNum.length) - 1)

  val acc = new Account()
  val crd = new CreditCard()
  val che = new Cheque()
  val sys = new System()

  def hello(): Unit = {
    println(s"Welcome to ${BOLD}The Bank${RESET}. Please select from the choices below:")
    println(s"${BOLD}1)${RESET} ${UNDERLINED}Account Details${RESET} \n${BOLD}2)${RESET} ${UNDERLINED}Credit Card Enquiries${RESET} \n${BOLD}3)${RESET} ${UNDERLINED}Deposit Cheque${RESET} \n${BOLD}4)${RESET} ${UNDERLINED}Set up an account with Us!${RESET}\n${BOLD}5)${RESET} ${UNDERLINED}Admin Login${RESET}")
    var selection: Int = readInt()
    selection match {
      case 1 => acc.userDetails()
      case 2 => crd.userDetails()
      case 3 => che.userDetails()
      case 4 => acc.accCreation()
      case 5 => sys.overview()
      case _ => BankingApp.hello()
    }
  }
  //NEED TO MAKE SURE EVERYTHING HAPPENS WITHIN HELLO FUNCTION
  //ONCE WE BREAK HELLO FUNCTION, ALL DATA RETURNS TO HARDCODED VALUES
  hello()
}