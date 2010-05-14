object Curr {
    
  //def curriedAdd(x:Int) = (y:Int) => x + y
  // is the same as :  
  def curriedAdd(x:Int)(y:Int)=x+y        
  
  def proceed(callback:() => Int): Int=callback();
  
  def process[A](filter:A=>Boolean)(list:List[A]):List[A] = {
      list.filter(filter).removeDuplicates.reverse  
  }

  def add(x:Int, y:Int, z:Int) = x + y + z
 
  def main(args: Array[String]): Unit =
  {           
    val c = Curr;
    val onePlus=c.curriedAdd(1)_
    println(onePlus(2))
    println(c.proceed(()=> onePlus(2)))    
    
    val even = (a:Int) => a % 2 == 0
    val notEven = (a:Int) => a % 2 != 0
    val numbers = 1::2::3::3::4::5::6::7::1::Nil
    
    val processEven=c.process(even)_    
    println("process even "+processEven(numbers))
    
    println("process not even "+c.process(notEven)(numbers))
    
    val addFive = add(5, _:Int, _:Int)
    println("Partials without Currying "+addFive(3, 1))  
    
    val addCurried = Function.curried(add _)    
    println("add curried "+addCurried(5)(3)(1));
    
    val addUncurried=Function.uncurried(curriedAdd _);
    println("add uncurried "+addUncurried(5,1));
    
    val addWithFirstAndThird = add(5, _:Int, 10)
    println(addWithFirstAndThird(40))

  }
  
}
