====== Iterative ===============

loop (5,4,3,2,1):
 each: result = result * n
 decrease n with 1
 repeat until 1

def fact(n:Int):Int = {
    var res = 1
    var i = n
    while(i>0) {
        println("Res: "+res+", i: " + i)
        res = i * res
        i = i -1
    }
    res
}


Result:
1   
5
20
60
120





====== Recursive ==============

def fact(n:Int):Int = {
   if(n > 0 ) n*fact(n) else 1
}


fact(5) = 5 * fact(4)
        = 5 * (4 * fact(3))
        = 5 * (4 * (3 * fact(2)))
        = 5 * (4 * (3 * (2 * fact(1))))
        = 5 * (4 * (3 * (2 * (1*fact(0)))))
        ....................................
        = 5 * (4 * (3 * (2 * (1*1))))
        = 5 * (4 * (3 * (2 * (1))))
        = 5 * (4 * (3 * (2)))
        = 5 * (4 * 6)
        = 5 * 24
        = 120

====== Tail recursive ======

def fact(n:Int) = { 
    def f(n:Int, a:Int):Int = {
        if(a > 0) {println("n: "+n+", a: "+a);f(n-1, a*n)} 
        else a
    }
    f(n,1)
}

fact(5)     = f(4, 1*5)
fact(4,5)   = f(3, 5*4)
fact(3,20)  = f(2, 20*3)
fact(2,60)  = f(1, 60*2)
fact(1,120) = 1 * 120

====== Pattern matching ====

def fact(n:Int):Int = {          
    n match {
        case 0 => 1
        case n => n * fact(n-1)
    }
}

[Same evaluation as recursive]

===== Pattern matching with tail recursion ===

def fact(n:Int):Int = {
     def f(n:Int, a:Int):Int = {
       n match {
          case 0 => a
          case n => f(n-1, a*n)
       }
     }
     f(1,n)
}




5 * 4 * 3 * 2 * 1

(5 * 4 * 3 * 2) * 1

((5 * 4 * 3) * 2) * 1

(((5 * 4) * 3) * 2) * 1

((((5) * 4) * 3) * 2) * 1

==========================

0 => 1
1 => 1
2 => 2 * 1
3 => 3 * 2 * 1
4 => 4 * 3 * 2 * 1
5 => 5 * 4 * 3 * 2 * 1

f(5,4,3,2,1) = 5 * f(4,3,2,1)

f(4,3,2,1) = 4 * f(3,2,1)

f(3,2,1) = 3 * f(2,1)

f(2) = 2 * f(1)

f(1) = 1


