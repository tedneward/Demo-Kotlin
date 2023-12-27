import kotlin.random.*

// {{## BEGIN basic ##}}
fun add(left: Int, right: Int): Int {
  return left + right
}
val five = add(2, 3)

val adder = fun(left: Int, right: Int): Int {
  return left + right
}
val six = adder(3, 3)

val adderUp = fun(left: Int, right: Int): Int = left + right
// {{## END basic ##}}

// {{## BEGIN variants ##}}
fun doComplicatedThings(a: Int = 0, b: Int = -1, c: Boolean = false): Int {
  return if (c) a else b
}
doComplicatedThings() // = -1
doComplicatedThings(c = true) // = 0

fun log(msg: String, vararg msgs: String): Unit {
  print(msg)
  for (m in msgs) {
    print(" " + m)
  }
  println()
} 
log("Howdy!")
log("Howdy","y'all!")
// {{## END variants ##}}

// {{## BEGIN lambdas ##}}
val ints = arrayOf(4, 8, 16)
val doubled = ints.map { it -> it * 2 }
val halved = ints.map { it / 2 }

fun doSomethingNTimes(times: Int, body: () -> Unit) {
  for (i in 1..times) {
    body()
  }
}
doSomethingNTimes(5) {
  println("Whee!")
}
// {{## END lambdas ##}}

fun processNonNullString(msg: String) { }
// {{## BEGIN let ##}}
/*
Instead of:

val numbers = mutableListOf("one", "two", "three", "four", "five")
val resultList = numbers.map { it.length }.filter { it > 3 }
println(resultList)   

we can write:
 */
val numbersStr = mutableListOf("one", "two", "three", "four", "five")
numbersStr.map { it.length }.filter { it > 3 }.let { 
    println(it)
}
// ... or even...
numbersStr.map { it.length }.filter { it > 3 }.let(::println)

// Safe null-value handling:
val str: String? = "Hello" // change to null to demonstrate
//processNonNullString(str)       // compilation error: str can be null
val length = str?.let { 
    println("let() called on $it")        
    processNonNullString(it)      // OK: 'it' is not null inside '?.let { }'
    it.length
}
// {{## END let ##}}

// {{## BEGIN with ##}}
// Assume numbersStr is mutableListOf("one", "two", "three", "four", "five")
val firstAndLast = with(numbersStr) {
    "The first element is ${first()}," +
    " the last element is ${last()}"
}
println(firstAndLast)             // "one", "five"
// {{## END with ##}}

// {{## BEGIN run ##}}
data class Person(var firstName: String = "", var lastName: String = "",
                  var age: Int = 0, var city: String = "")

// Attached (via extension) to an object
val person = Person().run {
    firstName = "Ted"
    lastName = "Neward"
    age = 51
}

// Generic block returning a result
val hexNumberRegex = run {
    val digits = "0-9"
    val hexDigits = "A-Fa-f"
    val sign = "+-"
    Regex("[$sign]?[$digits$hexDigits]+")
}
for (match in hexNumberRegex.findAll("+123 -FFFF !%*& 88 XYZ")) {
    println(match.value)
}// {{## END run ##}}

// {{## BEGIN apply ##}}
// Assume: data class Person(var firstName: String = "", var lastName: String = "",
//                           var age: Int = 0, var city: String = "")
val adam = Person("Adam").apply {
    age = 32
    lastName = "London"        
}
println(adam)
// {{## END apply ##}}

// {{## BEGIN also ##}}
numbersStr
    .also { println("The list elements before adding new one: $it") }
    .add("six")
// {{## END also ##}}

// {{## BEGIN take ##}}
val rngNumber = Random.nextInt(100)

val evenOrNull = rngNumber.takeIf { it % 2 == 0 }
val oddOrNull = rngNumber.takeUnless { it % 2 == 0 }
println("even: $evenOrNull, odd: $oddOrNull")

val hellostr = "Hello"
val caps = hellostr.takeIf { it.isNotEmpty() }?.uppercase()
//val caps = str.takeIf { it.isNotEmpty() }.uppercase() //compilation error
println(caps)
// {{## END take ##}}

// {{## BEGIN reflection ##}}
fun isOdd(x: Int) = x % 2 != 0
fun isOdd(s: String) = s == "brillig" || s == "slithy" || s == "tove"

val numbers = listOf(1, 2, 3)
println(numbers.filter(::isOdd)) // prints [1, 3]
    // since numbers is a list of Int, the IsOdd(Int) is selected

// Function composition
fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}
fun length(s: String) = s.length

val oddLength = compose(::isOdd, ::length)
val strings = listOf("a", "ab", "abc")

println(strings.filter(oddLength)) // Prints "[a, abc]"
// {{## END reflection ##}}

