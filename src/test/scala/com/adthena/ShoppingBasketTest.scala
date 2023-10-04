package com.adthena

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingBasketTest extends AnyFlatSpec with Matchers {

  "ShoppingBasket" should "calculate subtotal correctly" in {
    val basket = new ShoppingBasket()
    basket.addItem(Item("Apples"))
    basket.addItem(Item("Milk"))
    basket.calculateSubTotal()

    basket.getSubtotal shouldEqual BigDecimal("2.30")
  }

  it should "apply offers correctly" in {
    val basket = new ShoppingBasket()
    basket.addItem(Item("Soup"))
    basket.addItem(Item("Soup"))
    basket.addItem(Item("Bread"))
    basket.calculateSubTotal()
    basket.applyOffers()

    basket.getTotal shouldEqual BigDecimal("1.70")
  }
}
