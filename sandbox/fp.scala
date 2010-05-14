import java.io.File;
import java.io.PrintWriter;


object FP {
  
  def printOnce(callback: () => Unit): Unit =callback()
  
  def proceed(callback:() => Int): Int=callback();
     
  def proceedIncrement(callback:() => Int): Int= callback()+1;    
  
  def multiply  (a :Int, b: Int)={a*b}
  
  def withPrintWriter(file: File, operation: PrintWriter=>Unit)
  {
     val wr=new PrintWriter(file);
     try{
       operation(wr)
     }finally{
       wr.close();
     }
     
  }
  def twice (op: Int=>Int,  x:Int)=op(op(x))
  
    
  def main(args: Array[String]): Unit =
  {           
    val fp = FP;
    println(fp.proceed(()=> 4*5))   
    println(fp.proceed(()=> fp.multiply(4,5)))
    fp.withPrintWriter(
      new File("data.txt"),
      writer=>writer.println(new java.util.Date))
    println(fp.twice(_+1,5));
    println(fp.twice(_*2,5));        
  }
}

