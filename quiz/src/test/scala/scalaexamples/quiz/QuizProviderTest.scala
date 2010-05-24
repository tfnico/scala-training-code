package scalaexamples.quiz

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * Check out http://www.artima.com/scalatest/doc-0.9.5/org/scalatest/matchers/ShouldMatchers.html
 * for more info on the matchers.
 * @author tfnico
 *
 */
@RunWith(classOf[JUnitRunner])
class QuizProviderTest extends FunSuite with ShouldMatchers {
	
	val quiz = new XmlQuizProvider("quiz.xml").quiz
	
	test("Quiz should have title"){
		quiz.title should be ("The Example Quiz") 
	}
	
	test("should have questions") {
		quiz.questions should have size (3)
		quiz.questions(0).text should startWith ("In which")
	}
	
	test("should have 4 answers, one of which are correct") {
		quiz.questions(0).answers should have size (4)
		quiz.questions(0).answers.filter(_.correct).size should be (1)
	}
}
