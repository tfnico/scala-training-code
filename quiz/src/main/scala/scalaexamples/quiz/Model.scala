package scalaexamples.quiz

case class Quiz(title: String, questions: List[Question])
case class Question(text: String, answers: List[Answer])
case class Answer(text: String, correct: Boolean)

class GameLogic(quiz:Quiz) {
	
	var score = 0
	var questionIndex = 0
	
	def answer(n:Int) {
		
		if (correct(n)) score += 1 
		questionIndex += 1
		
	}
	
	def correct(n:Int):Boolean = {
		var question = quiz.questions(questionIndex)
		question.answers.zipWithIndex.foreach{ tuple => 
			val answer = tuple._1
			val index = tuple._2
			if(index == n && answer.correct) return true
		}
		false
	}
}
