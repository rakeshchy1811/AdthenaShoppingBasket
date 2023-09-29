package com.adthena

class ShoppingBasket {

  // Holds items, subtotal, total and any applied discounts.
  private var items: List[Item] = List()
  private var subtotal: BigDecimal = 0
  private var total: BigDecimal = 0
  private var discounts: List[(String, BigDecimal)] = List()

  // List of available offers
  private val offers: List[Offer] = List(new AppleOffer, new BreadOffer)

  // Adds an item to the shopping basket
  def addItem(item: Item): Unit = items :+= item

  // Calculates the subtotal of items in the basket.
  def calculateSubTotal(): Unit = subtotal = items.map(_.price).sum

  // Applies available offers and calculates the total amount after discounts.
  def applyOffers(): Unit = {
    discounts = offers.flatMap(offer => offer.apply(items))
    total = subtotal - discounts.map(_._2).sum
  }

  // Prints the summary including subtotal, any discounts, and the total amount.
  def printSummary(): Unit = {
    println(s"Subtotal: £$subtotal")
    if (discounts.nonEmpty)
      discounts.foreach { case (desc, amount) =>
        val formattedAmount = (amount.abs * 100).toInt
        println(s"$desc: ${formattedAmount}p")
      }
    else println("(No offers available)")
    println(s"Total price: £$total")
  }

  def getSubtotal: BigDecimal = subtotal
  def getTotal: BigDecimal = total
  def isEmpty: Boolean = items.isEmpty
}
