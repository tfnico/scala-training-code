package scalaexamples.quiz

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class QuizLogicTest extends FunSuite with ShouldMatchers {
	
	val quiz = MockQuiz.quiz
	
	test("2 correct answers should give 2 points") {
		
		val quizLogic = new QuizLogic
		quizLogic.answered( quizLogic.query("0", quiz.questions(0)).get)
		
		
		quizLogic.answered(quizLogic.query("1", quiz.questions(1)).get)
		
		quizLogic.score should be (2)
	}
	
	test("1 correct answer gives 1 point") {
		val quizLogic = new QuizLogic
		quizLogic.answered(quizLogic.query("0", quiz.questions(0)).get)
		quizLogic.answered(quizLogic.query("2", quiz.questions(1)).get)
		quizLogic.score should be (1)
	}
	
	test("Answering outside range should give no result") {
		val quizLogic = new QuizLogic
		val result = quizLogic.query("6", quiz.questions(0))
		assert(result == None)
	}
	
	test("Answering non-numerical should give no result") {
		val quizLogic = new QuizLogic
		val result = quizLogic.query("woop", quiz.questions(0))
		assert(result == None)
	}
	
}