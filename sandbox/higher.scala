val even = ((i:Int)) => i%2 == 0
val numbers = 1::2::3::Nil                                          
def test(numbers:List[Int], f:Int=>Boolean) = numbers.map(n => f(n))
test(numbers,even)

var assertionsEnabled = true

def myAssert(predicate: () => Boolean) = if(assertionsEnabled && !predicate() ) throw new AssertionError
myAssert(() => 6 > 3)
//myAssert(() => 3/0 == 0)

def myAssert2(predicate: => Boolean) = if(assertionsEnabled && !predicate()) throw new AssertionError

//parameters without brackets are called by-name parameters
myAssert2(5 > 3)

myAssert2(3 / 0 == 2)
// above runs

def myAssert3(predicate: Boolean) = if (assertionsEnabled && !predicate) throw new AssertionError
//myAssert3(3/0 == 3) 
//above blows up
