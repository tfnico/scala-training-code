println("hello " + args.toList)

try {
	args(5)
	for (s <- args){
		 println(s.toInt)
	}
} catch {
	case e: NumberFormatException => println("You need to give me some numbers, man..")
	case e => println("Error! " + e.getMessage())
}
