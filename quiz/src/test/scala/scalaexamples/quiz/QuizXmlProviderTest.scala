package scalaexamples.quiz

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class QuizXmlProviderTest extends FunSuite with ShouldMatchers {
	
	val quiz = new XmlQuizProvider("quiz.xml").quiz
	
	test("Should have title") {
		assert(quiz.title != null)
	}
	
	test("Title should actually be the real deal") {
		quiz.title should be ("The Example Quiz")
	}
	
	test("Quiz should have questions") {
		quiz.questions should not be 'empty
	}
	
	test("A question should have answers") {
		quiz.questions(0).answers should not be 'empty
	}
	
	test("One of the answers should be correct") {
		quiz.questions(0).answers.filter(_.correct) should have size (1)
	}
	
	test("First question should be about Japan") {
		quiz.questions(0).text should include ("Japan")
	}
	
	test("First answer should be 'Asia'") {
		quiz.questions(0).answers.filter(_.correct)(0).text should be ("Asia")
	}

}