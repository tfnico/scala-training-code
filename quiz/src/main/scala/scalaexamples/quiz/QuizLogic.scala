package scalaexamples.quiz

import scalaexamples.quiz._

/**
 */
class QuizLogic {
   
	var score = 0
	
	def query(input:String, question:Question):Option[Boolean] = {
		try {
			
			Some(question.answers(input.toInt).correct)
		} catch{
			case _ => None 
		}
	}
	
	def answered(result:Boolean) = {
//		(if (question.answers(input.toInt).correct))
		score = score + (if (result) 1 else 0)
	}
	
	
}
