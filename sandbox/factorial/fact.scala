/* Iterative */
def fact(n:Int) = {
    var result = 1
    var i = n
    while(i > 0){
        result = i * result
        i -=1
    }
    result
}

/* Recursive */
def fact(n:Int):Int = {
    if (n>0) n*fact(n-1) else 1
}

/* Tail recursive */
def fact(n:Int):Int = {

    def f(n:Int,result:Int):Int = if(n > 0) f(n-1, result*n) else result

    f(n, 1)
}


/* Pattern matching */
def fact(n:Int):Int = {
    n match {
        case 0 => 1
        case n => n *fact(n-1)
    }
}


/* Pattern matching with tail recursion */
def fact(n:Int) = {
    def f(n:Int, res:Int):Int = { 
        n match {
            case 0 => res
            case n => f(n-1, res * n)
        }
    }
    f(n,1)
}


/* Using fold */
def fact(n:Int) = (1 to n).foldLeft (1) ( (a:Int, b:Int) => a*b)

/* Can also infer the types */
def fact(n:Int) = (1 to n).foldRight (1) ((a,b) => a* b )

/* Or parameterless anonymous function */
def fact(n:Int) = (1 to n).foldRight (1) (_ * _)

/* Or just..  */
def fact(n:Int) = ((1 to n) :\ 1) (_ * _)

/* With reduce (won't support fact(0) */
def fact(n:Int) = (1 to n) reduceRight (_ * _)



