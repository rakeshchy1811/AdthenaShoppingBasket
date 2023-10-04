package com.adthena

// Case class representing an item with name and price.
case class Item(name: String, price: BigDecimal)

object Item {
  // A list of all available items.
  val availableItems: List[String] = List("Soup", "Bread", "Milk", "Apples")

  def apply(name: String): Item = name.toLowerCase match {
    // Match the provided name to a valid item and return the corresponding Item object.
    case "soup"   => Item("Soup", BigDecimal("0.65"))
    case "bread"  => Item("Bread", BigDecimal("0.80"))
    case "milk"   => Item("Milk", BigDecimal("1.30"))
    case "apples" => Item("Apples", BigDecimal("1.00"))
    // Throw an exception if the provided name does not match any valid item.
    case _ => throw new IllegalArgumentException(s"$name is not a valid item")
  }
}
