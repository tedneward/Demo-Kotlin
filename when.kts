// {{## BEGIN basic ##}}
val x = 2
when (x) {
  1 -> print("x == 1")
  2 -> print("x == 2")
  else -> { // Note the block
    print("x is neither 1 nor 2")
  }
}
// {{## END basic ##}}

val s = "Fred";
val y = "Fred Flintstone"

fun parseInt(s: String):Int {
  return 0
}

// {{## BEGIN complex ##}}
val validNumbers = 1..10
when (x) {
  0, 1 -> print("x == 0 or x == 1")
  parseInt(s) -> print("s encodes x")
  in 1..10 -> print("x is in the range")
  in validNumbers -> print("x is valid")
  !in 10..20 -> print("x is outside the range")
  else -> print("otherwise")
}

val hasPrefix = when(y) {
  is String -> y.startsWith("prefix")
  else -> false
}
// {{## END complex ##}}
