println("Entering when")
// {{## BEGIN basic ##}}
val x = 2
when (x) {
  1 -> println("x == 1")
  2 -> println("x == 2")
  else -> { // Note the block
    println("x is neither 1 nor 2")
  }
}
// {{## END basic ##}}

val y = "Fred Flintstone"

fun parseInt(s: String):Int {
  return 0
}

// {{## BEGIN complex ##}}
val s = "Fred";
val validNumbers = 1..10
when (x) {
  0, 1 -> println("x == 0 or x == 1")
  parseInt(s) -> println("s encodes x")
  in 1..10 -> println("x is in the range")
  in validNumbers -> println("x is valid")
  !in 10..20 -> println("x is outside the range")
  else -> println("otherwise")
}

val hasPrefix = when(y) {
  is String -> y.startsWith("prefix")
  else -> false
}
print(hasPrefix)
// {{## END complex ##}}
