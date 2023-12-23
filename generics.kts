// {{## BEGIN simple-generics-example ##}}
class Box<T>(t: T) {
    var value = t
}

val box1: Box<Int> = Box<Int>(1)
val box2 = Box(1) // 1 is-a Int, so box2 must be a Box<Int>
// {{## END simple-generics-example ##}}

// {{## BEGIN simple-generics-function ##}}
fun <T> singletonList(item: T): List<T> {
    // ...
}

fun <T,U> swap(params: Pair<T,U> ): Pair<U,T> {
    return Pair(params.second, params.first)
}
// {{## END simple-generics-function ##}}

