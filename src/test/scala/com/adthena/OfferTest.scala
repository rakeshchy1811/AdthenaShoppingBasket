package com.adthena

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class OfferTest extends AnyFlatSpec with Matchers {

  "AppleOffer" should "apply 10% discount on Apples correctly" in {
    val items = List(Item("Apples"), Item("Milk"))
    val appleOffer = new AppleOffer

    val discounts = appleOffer.apply(items)
    discounts should contain theSameElementsAs List(("Apples 10% off", BigDecimal("0.10")))
  }

  "BreadOffer" should "apply 50% discount on Bread when there are at least 2 Soups" in {
    val items = List(Item("Soup"), Item("Soup"), Item("Bread"))
    val breadOffer = new BreadOffer

    val discounts = breadOffer.apply(items)
    discounts should contain theSameElementsAs List(("Bread 50% off", BigDecimal("0.50")))
  }

  it should "not apply 50% discount on Bread when there are fewer than 2 Soups" in {
    val items = List(Item("Soup"), Item("Bread"))
    val breadOffer = new BreadOffer

    val discounts = breadOffer.apply(items)
    discounts shouldBe empty
  }
}