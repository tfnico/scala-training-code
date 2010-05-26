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

//Pretty printing
val printer = new scala.xml.PrettyPrinter(60,4)
printer.format(xml)

//Parsing

def typeOfList(xml:scala.xml.Elem) = {
    xml match {
        case <ul>{contents}</ul> => "Unordered list"
        case <ol>{contents}</ol> => "Ordered list"
        case _ => "Something else"
    }
}

// "Any sequence = _*

def typeOfList(xml:scala.xml.Elem) = {
    xml match {
        case <ul>{contents @ _*}</ul> => "Unordered list. Elements are: " + contents; for(elm <- contents) println("Found item "+elm)
        case <ol>{contents @ _*}</ol> => "Ordered list. Elements are: " + contents
        case _ => "Something else"
    }
}

val dirtyNamesXml = 
<ul>
    <li>Alf</li>
    <que>wut</que>
    <li>Fredrik</li>
</ul>

def typeOfDirtyList(xml:scala.xml.Elem) = {
    xml match {
        case <ul>{contents @ _*}</ul> => "Unordered list. Elements are: " + contents; for(elm @ <li>{_*}</li> <- contents) println("Found item "+elm)
    
        case <ol>{contents @ _*}</ol> => "Ordered list. Elements are: " + contents
        case _ => "Something else"
    }
}
