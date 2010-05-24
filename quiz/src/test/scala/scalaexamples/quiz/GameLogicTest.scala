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
class GameLogicTest extends FunSuite with ShouldMatchers {
	
	val quiz = new XmlQuizProvider("quiz.xml").quiz
	
	test("if no answers, score should be 0") {
		val gameLogic = new GameLogic(quiz)
		gameLogic.score should be (0) 
	}
	
	test("if three incorrect answers, score should be 0") {
		val gameLogic = new GameLogic(quiz)
		gameLogic.answer(3)
		gameLogic.answer(3)
		gameLogic.answer(3)
		gameLogic.score should be (0)
	}
	
	test("with three correct answers, score should be 3") {
		val gameLogic = new GameLogic(quiz)
		gameLogic.answer(0)
		gameLogic.answer(1)
		gameLogic.answer(1)
		gameLogic.score should be (3)
	}
	
	
}
