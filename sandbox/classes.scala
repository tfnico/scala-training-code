class MyClass(x:Int, y:Int, z:String) {
    require (x>0, "x should be greater than zero.")
    require (z.length >= 2, "lenght shoulld be greater than or equal to 2.")

    def this(x:Int, z:String) = this(x,1,z)

    def this(z:String) = this(3,z)

}

class MySubClass(x:Int, z:String) extends MyClass(5,z)


class Foo {
 def bar(x: Int) = {
   println("calling bar method from Foo class");
   x
  }
}

trait Foo1 extends Foo {
  
  override def bar(x: Int) = {
    println("calling bar method from Foo1 trait");
    x + super.bar(x)
  }
}


trait Foo2 extends Foo {
  
  override def bar(x: Int) = {
    println("calling bar method from Foo2 trait");
    x * super.bar(x)
  }
}
