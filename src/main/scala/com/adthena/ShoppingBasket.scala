package com.adthena

class ShoppingBasket {
  private var items: List[Item] = List()
  private var subtotal: BigDecimal = 0
  private var total: BigDecimal = 0
  private var discounts: List[(String, BigDecimal)] = List()

  // Define available offers
  private val offers: List[Offer] = List(new AppleOffer, new BreadOffer)

  def addItem(item: Item): Unit = items :+= item

  def calculateSubTotal(): Unit = subtotal = items.map(_.price).sum

  def applyOffers(): Unit = {
    // Apply all available offers and flatten the results to a list of discounts
    discounts = offers.flatMap(offer => offer.apply(items))
    total = subtotal - discounts.map(_._2).sum
  }

  def printSummary(): Unit = {
    println(s"Subtotal: £$subtotal")
    if (discounts.nonEmpty) discounts.foreach { case (desc, amount) =>
      val formattedAmount =
        (amount.abs * 100).toInt // Convert to positive pence value
      println(s"$desc: ${formattedAmount}p")
    }
    else println("(No offers available)")
    println(s"Total price: £$total")
  }

  def getSubtotal: BigDecimal = subtotal

  def getTotal: BigDecimal = total

  def isEmpty: Boolean = items.isEmpty
}
