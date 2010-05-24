package scalaexamples.quiz.console

import scalaexamples.quiz.{Answer, Question, Quiz, GameLogic}

class ConsoleGame(quiz: Quiz) {
	
  val logic =  new GameLogic(quiz)
  println("Welcome to our faboulus quiz called '" + quiz.title + "'")

  quiz.questions.foreach{ question =>
	  println(question.text)
	  
	  question.answers.zipWithIndex.foreach { touple =>
	 	  println("("+touple._2+") " + touple._1.text)
	  }
	  
	  logic.answer(readLine.toInt)
  }

  println("Your score: "+logic.score)
}
