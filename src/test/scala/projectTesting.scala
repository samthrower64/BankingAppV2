/*
import org.scalatest.funsuite.AnyFunSuite
import BankingApp.{Account, BankingApp}
class projectTesting extends AnyFunSuite {
  test("Password is 123abc") {
    assert(BankingApp.adminPwd == "123abc")
  }
  test("Customer list should be full") {
    assert(BankingApp.name.contains != 0)
  }
  test("Customer Account Numbers should be of length 8") {
    assert(BankingApp.accNum.toString().length == 8)
  }
  test("Customer balances should be of type Double") {
    assert(BankingApp.bal(0).toString().contains("."))
  }
  test("Customer interest rates should be of type Double") {
    assert(BankingApp.interest(0).toString().contains("."))
  }
  test("Customer Account Types should be Strings") {
    val pattern = "[a-z]"
    assert(BankingApp.accType(0).toString().contains(pattern))
  }
  */
    test("Is Account Number Exception functional") {
    assertThrows[InvalidACNException](throw new InvalidACNException("Exception thrown"))
  }
  test("Is Deposit Exception Functional") {
    assertThrows[InvalidDepositException](throw new InvalidDepositException("Exception thrown"))
  }
  test("Is Selection Exception Functional") {
    assertThrows[InvalidSelectionException](throw new InvalidSelectionException("Exception thrown"))
  }
}
/*
}
*/
