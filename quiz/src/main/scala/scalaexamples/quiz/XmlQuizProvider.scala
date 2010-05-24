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
	  
	  val title = (xml \\ "title").text 
	  
	  val questions = (xml \\ "item").map { elm =>
	   	 val answers = (elm \\ "option").map(parseOption).toList
	  	 new Question( (elm \ "question").text, answers)
	  }.toList
	  
	  new Quiz(title, questions)
	  
  }
  
  private def parseOption(node:NodeSeq):Answer = {
	  val text = node.text
	  val correct = (node \ "@correct").text == "y"
	  new Answer(text, correct)
  }
  
}
