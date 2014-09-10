package com.gu.contentapi.client.parser

import org.scalatest.{FlatSpec, Matchers}
import com.gu.contentapi.client.ClientTest

class SectionsJsonParserTest extends FlatSpec with Matchers with ClientTest {

  val sectionsResponse = JsonParser.parseSections(loadJson("sections.json"))

  it should "parse basic response fields" in {
    sectionsResponse.status should be ("ok")
    sectionsResponse.userTier should be ("developer")
    sectionsResponse.total should be (65)
  }


  it should "parse the sections" in {
    sectionsResponse.results.size should be (65)
    sectionsResponse.results.head.webTitle should be ("Community")
  }

}
