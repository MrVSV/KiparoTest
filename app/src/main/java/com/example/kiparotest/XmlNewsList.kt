package com.example.kiparotest

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(strict = false)
class XmlNewsList{
    @field:Element(name = "location", required = false) var location: String? = null
    @field:Element(name = "name", required = false) var name: String? = null
    @field:ElementList(name = "news", required = false) lateinit var news: List<XmlNews>
}

@Root
class XmlNews{
    @field:Element(name = "id", required = false) var id: Int? = null
    @field:Element(name = "title", required = false) var title: String? = null
    @field:Element(name = "description", required = false) var description: String? = null
    @field:Element(name = "date", required = false) var date: String? = null
    @field:Element(name = "visible", required = false) var visible: Boolean? = null
    @field:ElementList(name = "keywords", required = false) lateinit var keywords : List<String>
}


//@Root(name = "element")
//data class Keywords(
//    @field:Text
//    val element: String
//)


