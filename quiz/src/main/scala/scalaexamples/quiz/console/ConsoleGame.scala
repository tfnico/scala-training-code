package scalaexamples.quiz.console

import scalaexamples.quiz.{Answer, Question, Quiz}

class ConsoleGame(quiz: Quiz) {

  println("Welcome to our faboulus quiz called '" + quiz.title + "'")
  
  println("The questions are: ")

  var score = 0
  
  for (question:Question <- quiz.questions) {   
	  println(question.text)
	  question.answers.zipWithIndex.foreach{ pair => 
	   	println("("+pair._2 +") "+ pair._1.text)
	  }
	  val answer = readLine
	  if(correct(answer.toInt, question.answers)){
	 	  score += 1
	  }
  }
  
  println("Quiz complete! You got " + score + " out of 3 correct answers right!")
  
  def correct(answer:Int, answers:List[Answer]):Boolean = {
	  var correct = false
	  answers.zipWithIndex.foreach{ pair => 
	    if(answer == pair._2 && pair._1.correct) correct = true
	  }
	  correct
  }
   
  def printQuiz(quiz:Quiz) {
	quiz.questions.foreach{ question =>
		println(question.answers.filter(_.correct))
	}
  }
}
