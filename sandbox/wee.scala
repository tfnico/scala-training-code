class Ship(val x:Int, val y: Int) extends Iterable[(String,Int)] {

    def elements = new Iterator[(String,Int)] {
       private var nextVar = 'x

       def next : (String,Int) = nextVar match {
           case 'x => { nextVar = 'y; ("x",x) }
           case 'y => { nextVar = 'z; ("y",y) }
       }

       def hasNext : Boolean = nextVar != 'z
    }
}

def benchmark (body : => Unit): Long = {
    val start = java.util.Calendar.getInstance().getTimeInMillis()
    body
    val end = java.util.Calendar.getInstance().getTimeInMillis()
    end - start
}

