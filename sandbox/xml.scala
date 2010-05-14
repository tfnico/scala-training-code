var xml = 
        <xhtml>
            <body>
                <p>Hello, World</p>
            </body>
        </xhtml>


val name = "Scala course"


var xml = 
        <xhtml>
            <body>
                <p>Hello, { name }</p>
            </body>
        </xhtml>

val names = List("Alf", "Fredrik")

val namesXml = <ul>{ for (name <- names)  yield <li>{ name }</li>  }</ul>


var xml = scala.xml.XML.loadFile("filename.xml")

println("Now printing XML from file.") 
println(xml)

scala.xml.XML.saveFull("filename.xml", xml, "UTF-8", true, null)

//Parsing

def typeOfList(xml:scala.xml.Elem) = {
    xml match {
        case <ul>{contents}</ul> => "Unordered list"
        case <ol>{contents}</ol> => "Ordered list"
        case _ => "Something else"
    }
}

