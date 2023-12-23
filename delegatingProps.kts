import kotlin.properties.Delegates
import kotlin.reflect.*

class Delegate {
  operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
    return "$thisRef, thank you for delegating '${property.name}' to me!"
  }
 
  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
    println("$value has been assigned to '${property.name} in $thisRef.'")
  }
}

class Example {
  var p: String by Delegate()
}

val e = Example()
e.p = "NEW"
println(e.p)

// {{## BEGIN lazy ##}}
class Container {
  val lazyValue: String by lazy {
      println("computed!")
      "Hello"
  }
}
val c = Container()
println(c.lazyValue)
println(c.lazyValue)
// {{## END lazy ##}}

// {{## BEGIN observable ##}}
class User {
    var name: String by Delegates.observable("<no name>") {
        prop, old, new ->
        println("$old -> $new")
    }
}

val user = User()
user.name = "first"
user.name = "second"
// {{## END observable ##}}

// {{## BEGIN map ##}}
class Person(val map: Map<String, Any?>) {
  val name: String by map
  val age: Int     by map
}
val person = Person(mapOf(
    "name" to "John Doe",
    "age"  to 25
))
println(person.name)
println(person.age)
println(person.map)
// {{## END map ##}}
