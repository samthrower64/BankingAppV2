package BankingApp

import scala.Console.{BOLD, RESET}
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readDouble, readInt, readLine}
import BankingApp.{accNum, accType, bal, increment, interest, name}

class Account {
  //variable allows us to generate new account numbers incrementally
  def returner(): Unit = {
    println("Returning you to the main menu...");
    BankingApp.hello()
  }
  // FIRST CHOICE OF ACCOUNT
  @throws(classOf[InvalidACNException])
  def userDetails(): Unit = {
    println("Please enter your account number")
    val accNum1: Int = readInt()
    if ((accNum1.toString.length == 8) && accNum.contains(accNum1)) {
      val i1 = accNum.indexOf(accNum1)
      println("Hello\n" + name(i1) + ".\nYour " + accType(i1) + "\nof number: " + accNum(i1) + "\ncontains: £" + bal(i1) + "\nrunning at: " + interest(i1) +"% interest.\n\n")
      println("What would you like to do next?\n")
      println(s"${BOLD}Account Details${RESET}\nPress 1 to Add Money to your Account\nPress 2 to Withdraw money from your account\nPress Anything else to Return to the Main Menu")
      var selection:Int = readInt()
      selection match {
        case 1 => addFundsLogin()
        case 2 => withdrawFundsLogin()
        case _ => returner()
      }
    }
    else {
      throw new InvalidACNException("Invalid Account Number.")
    }
  }
  // SECOND CHOICE OF ACCOUNT
  @throws(classOf[InvalidACNException])
  def addFundsLogin(): Unit = {
    println("Please enter your account number")
    val accNum2 = readInt()
    if ((accNum2.toString.length == 8) && accNum.contains(accNum2)){
      addFunds(accNum2)
    } else {
      throw new InvalidACNException("Invalid Account Number.")
    }
  }

  @throws(classOf[InvalidDepositException])
  def addFunds(aNum: Int): Unit = {
    val i2 = accNum.indexOf(aNum)
    //above takes user account number to locate specific account
    //this code could be ineff here lines REMOVE THIS BEFORE SUBMIT
    println("How much would you like to deposit today? (format pounds.pence also, even if 00): ")
    var funds1a = readDouble() //reads user input
    //if statement decides if this is a valid number to input, exception thrown otherwise
    //this is an example of an exception being used in an IF/ELSE statement
    if (funds1a > 5000.00 || aNum < 0.00) {
      throw new InvalidDepositException("You must deposit between £0 and £5000 at any one time.")
    }
    else {
      println("Deposit request meets requirements for single deposit")
      bal(i2) += funds1a
    }
    var x = "%1.2f".format(bal(i2))
    println(s"Your funds have been added to your account successfully!\nYour new balance is ${BOLD}£$x${RESET}\n\nHave a Great Day! ")
    returner()
  }

  def withdrawFundsLogin(): Unit = {
    println("Please enter your account number")
    val accNum2 = readInt()
    if ((accNum2.toString.length == 8) && accNum.contains(accNum2)) {
      withdrawFunds(accNum2)
    } else {
      println("Invalid Account Number")
    }
  }

  def withdrawFunds(aNum: Int): Unit = {
    val i3 = accNum.indexOf(aNum)
    //above takes user account number to locate specific account
    //this code could be ineff here lines REMOVE THIS BEFORE SUBMIT
    println("How much would you like to withdraw today? (format pounds.pence also, even if 00): ")
    var funds2a = readDouble() //reads user input
    //if statement decides if this is a valid number to input, exception thrown otherwise
    //this is an example of an exception being used in an IF/ELSE statement
    if (funds2a > 5000.00 || aNum < 0.00) {
      throw new InvalidDepositException("You can only withdraw between £0 and £250 at any one time.")
    }
    else {
      println("Deposit request meets requirements for single deposit")
      bal(i3) -= funds2a
    }
    val x = "%1.2f".format(bal(i3))
    /*HERE i would potentially add code which updates the values held in ListBuffer
    above, but as these are hard coded, they will re-instantiate on each
    run of the program.
     */
    println(s"Your funds have been added to your account successfully!\nYour new balance is ${BOLD}£$x${RESET}\n\nHave a Great Day! ")
    returner()
  }
  def accCreation(): Unit = {
    val increment1: Int = increment + 1
    val newAccName = readLine("Enter your First Name: ")
    name += newAccName
    println("Enter your opening balance: ")
    val newBal = readDouble()
    bal += newBal
    accNum += increment1
    accSelection(increment1)
  }
  def accSelection(aNum:Int): Unit = {
    val whatAcc = readLine("Which type of account would you like to open with us?: \nPress 1 for Standard Account\nPress 2 for Savings Account\n")
    whatAcc match {
      case "1" => standardAccount(aNum)
      case "2" => savingsAccount(aNum)
      case _ => println("That is not an option. Sorry!"); accSelection(aNum)
    }
    println("Account added successfully")
    println("Returning you to the main menu..."); returner()
  }
  def standardAccount(aNum:Int): Unit = {
    val i = accNum.indexOf(aNum)
    accType += ("Standard Account")
    interest += 0.75
    println(s"You will receive " + interest(i) +"% interest each year with this account")
    returner()
  }
  def savingsAccount(aNum:Int): Unit = {
    val i = accNum.indexOf(aNum)
    accType += ("Savings Account")
    interest += 1.15
    println(s"You will receive "+ interest(i) +"% interest each year with this account")
    println("New Account Created, thanks for joining us" + name(i))
    returner()
  }
  def accDeletion(): Unit = {
    println("Enter the account number of the account you wish to delete")
    val accNum6 = readInt()
    val i4 = accNum.indexOf(accNum6)
    name -= name(i4)
    accNum -= accNum(i4)
    accType -= accType(i4)
    bal -= bal(i4)
    interest -= interest(i4)
    println("Account has been deleted successfully")
    returner()
  }

}

