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

// {{## BEGIN fns-w-receivers ##}}

// {{## END fns-w-receivers ##}}

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