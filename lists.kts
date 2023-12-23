val items = listOf(1, 2, 3, 4)
items.first() == 1
items.last() == 4
val evens = items.filter { it % 2 == 0 }
println(evens == listOf(2, 4)) // true

val rwList = mutableListOf(1, 2, 3, 4)
if (rwList.none { it > 6})
  println("No item in rwList is greater than 6")
