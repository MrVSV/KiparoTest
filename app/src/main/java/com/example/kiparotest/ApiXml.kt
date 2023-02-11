package com.example.kiparotest

import android.util.Xml
import org.xmlpull.v1.XmlPullParser
import java.io.InputStream

//class ApiXml {
//
//    private val ns: String? = null
//
//    fun parse(inputStream: InputStream): List<*> {
//        inputStream.use {
//            val parser: XmlPullParser = Xml.newPullParser()
//            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
//            parser.setInput(it, null)
//            parser.nextTag()
//            return readFeed(parser)
//        }
//    }
//    private fun readFeed(parser: XmlPullParser): List<NewsXml> {
//        val entries = mutableListOf<NewsXml>()
//
//        parser.require(XmlPullParser.START_TAG, ns, "feed")
//        while (parser.next() != XmlPullParser.END_TAG) {
//            if (parser.eventType != XmlPullParser.START_TAG) {
//                continue
//            }
//            // Starts by looking for the entry tag
//            if (parser.name == "entry") {
//                entries.add(readEntry(parser))
//            } else {
//                skip(parser)
//            }
//        }
//        return entries
//}