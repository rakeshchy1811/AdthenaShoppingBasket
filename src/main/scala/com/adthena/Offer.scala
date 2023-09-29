package com.adthena

// Trait representing any kind of offer
trait Offer {
  def apply(items: List[Item]): List[(String, BigDecimal)]
}

// Offer for Apples
class AppleOffer extends Offer {
  override def apply(items: List[Item]): List[(String, BigDecimal)] = {
    // Calculate total Apple discount
    val discount = items.filter(_.name == "Apples").map(_.price * 0.10).sum
    if (discount > 0) List(("Apples 10% off", discount)) else List()
  }
}

// Offer for Bread
class BreadOffer extends Offer {
  override def apply(items: List[Item]): List[(String, BigDecimal)] = {
    // Count eligible items for discount
    val breadCount = items.count(_.name == "Bread")
    val soupCount = items.count(_.name == "Soup")

    // Apply Bread discount if conditions are met
    if (soupCount >= 2 && breadCount >= 1)
      List(("Bread 50% off", breadCount * 0.40))
    else List()
  }
}
