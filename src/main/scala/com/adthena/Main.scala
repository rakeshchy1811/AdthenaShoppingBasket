package com.adthena

import org.slf4j.LoggerFactory
import scala.util.{Try, Success, Failure}

object Main {
  @main def run(args: String*): Unit = {
    val logger = LoggerFactory.getLogger(getClass)
    println("Welcome to Adthena Shopping Basket!")

    val actualArgs =
      if args.nonEmpty && args.head == "PriceBasket" then args.tail else args

    if actualArgs.isEmpty then {
      println("Please provide items in the basket")
      System.exit(1)
    }

    try {
      val basket = new ShoppingBasket()

      val (validItems, invalidItems) = actualArgs
        .map(arg => Try(Item(arg)))
        .partition(_.isSuccess)

      validItems
        .collect { case Success(item) => item }
        .foreach(basket.addItem)

      if invalidItems.nonEmpty then {
        val errors = invalidItems.collect { case Failure(e) => e.getMessage }.mkString(", ")
        println(s"Sorry! We are unable to process Item: $errors")
        println(s"Available items in stock are: ${Item.availableItems.mkString(", ")}")
        println("Try Again")
        System.exit(1)
      }

      if basket.isEmpty then {
        println("Basket is empty. Please add valid items to the basket.")
        System.exit(1)
      }

      basket.calculateSubTotal()
      basket.applyOffers()
      basket.printSummary()
    } catch {
      case e: Exception =>
        println("An unexpected error occurred. Please check the logs for more details.")
        System.exit(1)
    }
  }
}
