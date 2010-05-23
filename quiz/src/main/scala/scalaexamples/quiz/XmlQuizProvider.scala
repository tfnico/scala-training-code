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

  private def correct(elm:NodeSeq):Boolean = elm.text == "y"
  
  /**
   * TODO: Implement parsing of the XML into a Quiz object with questions and answers
   */
  private def parseXml(xml: Elem): Quiz = {
	  val title = (xml \\ "title").text
	  
	  val questions = scala.collection.mutable.Set[Question]()
	  
	  (xml \\ "item").foreach{elm => 
	   	   val questionText = (elm \ "question").text
	   	   val answers = 
	   	  	   for { 
	   	  	  	   option <- ( elm \\ "option" )
	   	  	   } yield new Answer(option.text, correct(option \ "@correct"))
	   	  	   
	   	  	     
	 	   questions.add(new Question( questionText, answers.toList)) 
	 	   
	 	   println(elm \\ "answer")
	 	   
	  }
	  
	  new Quiz(title, questions.toList)
  }
  
}
