val a: Int = 10000
print(a === a) // Prints 'true'

val boxedA: Int? = a
val anotherBoxedA: Int? = a
print(boxedA === anotherBoxedA) // !!!Prints 'false'!!!

val b: Byte = 1 // OK, literals are checked statically
// val i: Int = b // ERROR
val i: Int = b.toInt() // OK: explicitly widened
