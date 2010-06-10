package scalaexamples.quiz.console

import scalaexamples.quiz._

class ConsoleGame(quiz: Quiz) {

  println("Welcome to our faboulus quiz called '" + quiz.title + "'")

  val quizLogic = new QuizLogic
  
  quiz.questions.foreach { question =>
		
  		quizLogic.answered( ask(question) )
		
	}
  
  println("Congratulations! Your score is " + quizLogic.score)
  
  
  
  def ask(question: Question):Boolean = {
	println(question.text)
	  
	question.answers.zipWithIndex.foreach { touple =>
		println(touple._2 + ": " + touple._1.text)
	}
	val input = readLine
	
	val result = quizLogic.query(input, question)
	result match {
		case None => {
			println("You stupid fool! Enter an integer 0..3 ")
			ask(question) 
		}
		case Some (weee) => weee
	}  
  }
  
}
