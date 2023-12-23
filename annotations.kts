// {{## BEGIN definition ##}}
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Fancy

annotation class Special(val why: String)
// {{## END definition ##}}

annotation class Suspendable

// {{## BEGIN simple-example ##}}
@Fancy class Foo {
    @Fancy fun baz(@Fancy foo: Int): Int {
        return (@Fancy 1)
    }
}

class InFoo @Inject constructor(dependency: MyDependency) {
    // ...
    var x: MyDependency? = null
        @Inject set
}

@Special("Because it's a Foo too!") class FooTwo {}

val f = @Suspendable { Fiber.sleep(10) }
// {{## END simple-example ##}}

annotation class Ann()

// {{## BEGIN use-site-example ##}}
@file:JvmName("Example")

class Example(@field:Ann val foo,    // annotate Java field
              @get:Ann val bar,      // annotate Java getter
              @param:Ann val quux)   // annotate Java constructor parameter
// {{## END use-site-example ##}}

