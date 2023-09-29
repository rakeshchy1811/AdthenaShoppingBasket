package com.adthena

import org.slf4j.LoggerFactory
import scala.util.{Try, Success, Failure}

object Main {
  def main(args: Array[String]): Unit = {
    // Initialize logger for logging.
    val logger = LoggerFactory.getLogger(getClass)

    println("Welcome to Adthena Shopping Basket!")

    // Process command-line arguments.
    val actualArgs =
      if (args.nonEmpty && args.head == "PriceBasket") args.tail else args

    // Check if any item is provided in the command-line arguments.
    if (actualArgs.isEmpty) {
      println("Please provide items in the basket")
      System.exit(1)
    }

    try {
      // Create a new ShoppingBasket object.
      val basket = new ShoppingBasket()

      // Validate provided items and partition them into valid and invalid items.
      val (validItems, invalidItems) = actualArgs
        .map(arg => Try(Item(arg)))
        .partition(_.isSuccess)

      // Add valid items to the basket.
      validItems
        .collect { case Success(item) => item }
        .foreach(basket.addItem)

      // Handle invalid items, if any.
      if (invalidItems.nonEmpty) {
        val errors = invalidItems
          .collect { case Failure(e) => e.getMessage }
          .mkString(", ")
        println(s"Sorry! We are unable to process Item: $errors")
        println(
          s"Available items in stock are: ${Item.availableItems.mkString(", ")}"
        )
        println("Try Again")
        System.exit(1)
      }

      // Handle the case where no valid items are provided.
      if (basket.isEmpty) {
        println("Basket is empty. Please add valid items to the basket.")
        System.exit(1)
      }

      // Calculate the subtotal, apply offers, and print the summary.
      basket.calculateSubTotal()
      basket.applyOffers()
      basket.printSummary()
    } catch {
      // Handle unexpected exceptions and log the error.
      case e: Exception =>
        println(
          "An unexpected error occurred. Please check the logs for more details."
        )
        System.exit(1)
    }
  }
}
