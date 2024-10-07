// {{## BEGIN casts-1 ##}}
open class Mammal

class Human(val name : String = "Fred") : Mammal()
class Bear() : Mammal()

fun offerBeer(body : Mammal) {
  if (body is Human)
    println("Here, have a beer, ${body.name}")
}
val human = Human("Ted")
val bear = Bear()
offerBeer(human)
offerBeer(bear) // Exception!
// {{## END casts-1 ##}}

// {{## BEGIN casts-2 ##}}
fun offerWhiskey(body : Mammal) {
  body as Human 
}
offerWhiskey(human)
//offerWhiskey(bear)
  /*
  Exception! java.lang.ClassCastException: class Inheritance$Bear cannot be cast to class Inheritance$Human
   */
// {{## END casts-2 ##}}


// {{## BEGIN properties ##}}
open class Person(val firstName: String, val lastName: String, val age: Int)
{
  open var salary: Int = 50000
}

class Actor(val name: String, var oscars: Int) :
  Person(name, "", 39)
{
  override var salary: Int
    get() { return 1000000 }
    set(value) { /* ignored */ }
}

val willSmith = Actor("Will", 0)
println(willSmith.salary)
// {{## END properties ##}}

// {{## BEGIN methods ##}}
open class Base {
  open fun v() { }
  fun nv() { }
}

class Derived() : Base() {
  override fun v() { }
}
// {{## END methods ##}}

// {{## BEGIN abstract ##}}
abstract class Shape(val x : Int, val y : Int) {
  abstract val area : Double
  abstract val perimeter : Double
}
class Circle(x : Int, y : Int, val radius : Int) : Shape(x,y) {
  override val area : Double
    get() { return 3.14 * radius * radius }
  override val perimeter : Double
    get() { return 2 * 3.14 * radius}
}

val shapes = listOf(Circle(0,0,3))
for (shape in shapes)
    println(shape.area)
// {{## END abstract ##}}
