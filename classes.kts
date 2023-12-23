import kotlin.collections.*
import java.util.*

/*
// {{## BEGIN simple ##}}
class Person(var firstName: String, val lastName: String, var age: Int)
{
  init {
    println("Person $firstName $lastName constructed")
  }
}
val ted = Person("Ted", "Neward", 45)
println("${ted.firstName} is ${ted.age} years old")
// {{## END simple ##}}
*/

// {{## BEGIN secondary ##}}
class Person(var firstName: String, val lastName: String, var age: Int)
{
  constructor(soleName: String, age: Int) 
    : this(soleName, "", age)
  {
  }
}
val ted = Person("Ted", "Neward", 45)
println("${ted.firstName} is ${ted.age} years old")
val cher = Person("Cher", 39)
println("${cher.firstName} is ${cher.age} years old")
// {{## END secondary ##}}

// {{## BEGIN properties ##}}
public class Address { 
  public var name: String = ""
  public var street: String = ""
  public var city: String = ""
  public var state: String? = ""
  public var zip: String = ""
}
val addr = Address()
addr.name = "Fred Flintstone"
addr.street = "1 Bedrock Way"
// {{## END properties ##}}

// {{## BEGIN getter-setter ##}}
class SecretAsset {
  var codeName: String = ""
  var realName: String = ""
    get() = "<REDACTED>"
    set(value) {
      field = value
    }
}
// {{## END getter-setter ##}}

// {{## BEGIN backing-properties ##}}
class Container {
  private var _table: Map<String, Int>? = null
  public val table: Map<String, Int>
    get() {
      if (_table == null)
        _table = HashMap()
      return _table ?: throw AssertionError("Set to null by another thread")
    }
}
// {{## END backing-properties ##}}

// {{## BEGIN methods ##}}
class FootballPlayer {
  fun run() { println("Running!") }
  fun pass() { println("Passing!") }
}
val genoSmith = FootballPlayer()
genoSmith.run()
genoSmith.pass()
// {{## END methods ##}}

// {{## BEGIN operators ##}}
data class Money(val amount: Int, val currency: String = "USD") {
  operator fun plus(other: Money): Money {
    if (this.currency != other.currency)
      throw Exception("Conversion required!")
    else
      return Money(this.amount + other.amount, this.currency)
  }
}
operator fun Money.unaryMinus() = Money(-amount, currency)

val salary = Money(100000, "USD")
val bonus = Money(50000, "USD")
println(salary + bonus)
// {{## END operators ##}}

// {{## BEGIN infix ##}}
class Matrix(var number : Int) {
  infix fun rotate(amt: Int): Matrix {
    return this
  }
}
var m = Matrix(5)
m = m rotate 5
// {{## END infix ##}}

/*
// {{## BEGIN data ##}}
data class Money(var amount: Int, val type: String)
val salary = Money(100000, "USD")
println("Your salary is ${salary.type}${salary.amount}")
val euroSalary = salary.copy(type = "EUR")
println("In Europe, you would make ${euroSalary}")
// {{## END data ##}}
*/


// {{## BEGIN sealed ##}}
sealed class Expr {
    class Const(val number: Double) : Expr()
    class Sum(val e1: Expr, val e2: Expr) : Expr()
    object NotANumber : Expr()
}
fun eval(expr: Expr): Double = when(expr) {
    is Expr.Const -> expr.number
    is Expr.Sum -> eval(expr.e1) + eval(expr.e2)
    Expr.NotANumber -> Double.NaN
    // the `else` clause is not required because we've covered all the cases
}
val expr = Expr.Sum(Expr.Const(2.0), Expr.Const(2.0))
println("${expr.e1} + ${expr.e2} = ${eval(expr)}") // 4.0
// {{## END sealed ##}}
