import java.io.*
import kotlin.io.*

//{{## BEGIN implementSerializable ##}}
class Person(var firstName: String, val lastName: String, var age: Int) : java.io.Serializable
{
  init {
    println("Person $firstName $lastName constructed")
  }
}
val ted = Person("Ted", "Neward", 45)
println("${ted.firstName} is ${ted.age} years old")
//{{## END implementSerializable ##}}

// {{## BEGIN writeObject ##}}
val oos = ObjectOutputStream(FileOutputStream("person.ser"))
oos.writeObject(ted)
oos.close()
// {{## END writeObject ##}}

// {{## BEGIN readObject ##}}
val ois = ObjectInputStream(FileInputStream("person.ser"))
val readTed = ois.readObject() as Person
ois.close()
println("${readTed.firstName} is ${readTed.age} years old")
// {{## END readObject ##}}
