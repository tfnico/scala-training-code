def mens (conditional: => Boolean) (body: => Unit) {
    if(conditional){
        body
        mens (conditional) (body)
    }
}


class Repeater(body: => Unit) {
    def until(condition: => Boolean) {
        body
        if(!condition) new Repeater(body).until(condition)
    }
}

//def repeat( body: => Unit) = new Repeater(body)
/*
var count = 0
count: Int = 0
scala> repeat {
| count+=1
| println(count)
| } until(count >= 5)
*/



