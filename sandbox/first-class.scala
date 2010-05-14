object Even extends Function1[Int,Boolean] {
    def apply(in:Int) = in % 2 == 0 
}

object Even2 extends ( (Int) => Boolean ) {
    def apply(in:Int) = in % 2 == 0
}

def useEven (f:Int => Boolean) = f(13)



object NotEven extends Function[Int, Boolean] {
    def apply(in:Int) = in % 2 != 0
}

def const(m:Any) = m match {
    case 1 => println("First was hit")
    case 2 => println("Second was hit")
    case value => println(value)
}


def listMatch(l: List[Any]) = l match {
    case List(1, _,_) => println("I'm the first list")
    case List(2, _*) => println ("I'm the 2 with more")
    case l:List[Int] => println("A list of ints")
}


abstract class Property

case class Address(val street:String)

/*j
object Address {
        def apply(city:String) = new Address(city)
}
*/

case class House(address:Address, val value:Double) extends  Property


def constructorMatch (p:Property) = p match {
    case House(Address("Bonn"),_) => 1.0
    case House(Address("Koeln"),_) => 1.5
}


case class Office(address: Address, val value:Double) extends Property {
    override def equals(o:Any) = false
}


def optionious () = {
      var map = Map("Hi"-> "English", "Hallo"->"Deutsch")
      val result = map.get("Hallo")
      result match {
          case None => println("No key found")
          case Some(x) => println("Found value"+x)
      }
}

