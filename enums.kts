// {{## BEGIN basic ##}}
enum class Direction {
  NORTH, SOUTH, EAST, WEST
}
val heading = Direction.NORTH
println(heading)
// {{## END basic ##}}

// {{## BEGIN values ##}}
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}
val r = Color.RED
println(r.rgb)
// {{## END values ##}}

// {{## BEGIN anon ##}}
enum class ProtocolState {
  WAITING {
    override fun signal() = TALKING
  },

  TALKING {
    override fun signal() = WAITING
  };

  abstract fun signal(): ProtocolState
}
var state = ProtocolState.WAITING
println(state) //  WAITING
state = state.signal()
println(state) // TALKING
// {{## END anon ##}}
