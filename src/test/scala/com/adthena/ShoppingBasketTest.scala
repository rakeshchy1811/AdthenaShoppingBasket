package com.adthena

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingBasketTest extends AnyFlatSpec with Matchers {

  "ShoppingBasket" should "calculate subtotal correctly" in {
    val basket = new ShoppingBasket()
    basket.addItem(Item("Apples"))
    basket.addItem(Item("Milk"))
    basket.calculateSubTotal()

    basket.getSubtotal shouldEqual 2.30
  }

  it should "apply offers correctly" in {
    val basket = new ShoppingBasket()
    basket.addItem(Item("Soup"))
    basket.addItem(Item("Soup"))
    basket.addItem(Item("Bread"))
    basket.calculateSubTotal()
    basket.applyOffers()

    basket.getTotal shouldEqual 1.70 // 0.65*2 + (0.80 - 0.40) = 1.70
  }
}
