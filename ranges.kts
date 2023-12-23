val nums = 0..10 // 0,1,2,3,...,10
if (1 in nums)
  println("true!")

val desc = 10 downTo 0 // 10,9,8,...,0

val evens = 0..10 step 2 // 0,2,4,...,10
if (5 in evens)
  println("Errr... broken?")

val odds = 1..10 step 2 // 1,3,5,...,9
if (5 in odds)
  println("true!")