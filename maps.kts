val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
println(readWriteMap["foo"])  // prints "1"

val snapshot: Map<String, Int> = HashMap(readWriteMap)
println(snapshot)
//snapshot["foo"] = 12 // ERROR!
