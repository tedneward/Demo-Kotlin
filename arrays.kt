fun main(args: Array<String>) {

// {{## BEGIN arrays ##}}
val nums = arrayOf(1, 2, 3) // [1, 2, 3]
println(nums[0])
//nums[1] = 12 // ERROR!
println(nums[2])

val nulls : Array<Any?> = arrayOfNulls(3) // [null, null, null]

val asc = Array(5, { i -> (i * i).toString() }) // [0,1,4,9,16]
println(asc)
// {{## END arrays ##}}

}

