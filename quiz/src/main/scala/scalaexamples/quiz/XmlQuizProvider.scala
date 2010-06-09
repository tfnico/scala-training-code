package scalaexamples.quiz

import xml._

/**
 * This class parses the xml from a file.
 */
class XmlQuizProvider(file: String) extends QuizProvider {

  def quiz = {
     val xmlFromFile = XML.load(getClass.getClassLoader.getResourceAsStream(file))
     parseXml(xmlFromFile)
  } 

  /**
   * TODO: Implement parsing of the XML into a Quiz object with questions and answers
   */
  private def parseXml(xml: Elem): Quiz = {
	  val title = (xml \ "title").text
	  
	  val questions = (xml \\ "item").map{ elm => 
	   
	   		val answers = (elm \\ "option").map { optionElm =>
	   		
	   			val correct = (optionElm \ "@correct").text == "y" 
	   			val answerText = optionElm.text
	   			Answer(answerText, correct)
	   		}
	   		val questionText = (elm \ "question").text
	   		Question(questionText,answers.toList)
	  }
	  new Quiz(title, questions.toList)
  }
  
}
