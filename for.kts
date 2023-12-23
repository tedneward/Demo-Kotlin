val array = arrayOf(1, 2, 3, 4, 5, 6)
for (i in array)
  println(i)

for (idx : Int in array) {
  println(idx)
}

for (index in array.indices) {
  println(array[index])
}

for ((index,value) in array.withIndex()) {
  println("the array element at $index holds $value")
}