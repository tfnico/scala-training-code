class Person(val name:String, val age:Int) extends Ordered[Person] {
	require (age >= 0, "Age must be greater than zero, but was "+age) 
	override def toString = "Person:" + name + age
	
    def compare(other: Person) = this.age compare other.age
}


object Person {
	val ageLimit = 18
	def countPersons(persons:List[Person]) = persons.size

	def countPersons(persons:Person*) = persons.size

	def oldEnough(persons:List[Person]):List[Person] = {
		persons.filter(_.age > ageLimit)

	}

	def apply(name:String, age:Int) = new Person(name,age)
}


trait Callable {
	def number:Int
	def isNorwegian = number.toString.startsWith("47")
}


class RealPerson(val number:Int, override val name:String, override val age:Int) extends Person(name, age) with Callable


class House(val number:Int) extends Object with Callable

val ferris = new Person("Ferris",25)
val jonas = new Person("Jonas", 5)

val persons = ferris :: jonas :: Nil
