package com.adthena

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ItemTest extends AnyFlatSpec with Matchers {

  "Item" should "return correct price for Soup" in {
    val item = Item("Soup")
    item.price shouldEqual 0.65
  }

  it should "throw IllegalArgumentException for unknown item" in {
    assertThrows[IllegalArgumentException] {
      Item("Unknown")
    }
  }
}
