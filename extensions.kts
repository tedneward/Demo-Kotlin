// {{## BEGIN extension-fun ##}}
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

val l = mutableListOf(1, 2, 3)
l.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'l'
// {{## END extension-fun ##}}

// {{## BEGIN extension-prop ##}}
val <T> List<T>.lastIndex: Int
    get() = size - 1

l.size      // returns 3
l.lastIndex // returns 2
// {{## END extension-prop ##}}
