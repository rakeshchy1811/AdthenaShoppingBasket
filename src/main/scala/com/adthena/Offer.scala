package com.adthena

trait Offer {
  def apply(items: List[Item]): List[(String, BigDecimal)]
}

class AppleOffer extends Offer {
  override def apply(items: List[Item]): List[(String, BigDecimal)] = {
    val discount = items.filter(_.name == "Apples").map(_.price * 0.10).sum
    if (discount > 0) List(("Apples 10% off", discount)) else List()
  }
}

class BreadOffer extends Offer {
  override def apply(items: List[Item]): List[(String, BigDecimal)] = {
    val breadCount = items.count(_.name == "Bread")
    val soupCount = items.count(_.name == "Soup")
    if (soupCount >= 2 && breadCount >= 1)
      List(("Bread 50% off", breadCount * 0.40))
    else List()
  }
}
