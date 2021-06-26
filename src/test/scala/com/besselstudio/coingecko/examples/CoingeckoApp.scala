package com.besselstudio.coingecko.examples

import com.besselstudio.coingecko.CoingeckoApi
import com.besselstudio.coingecko.client.CoingeckoClientImpl
import sttp.client3.{HttpURLConnectionBackend, Identity, SttpBackend}

import scala.util.{Failure, Success, Try}

object CoingeckoApp extends App {
  println(s"Coingecko App Start")
  implicit lazy val backend: SttpBackend[Identity, Any] = HttpURLConnectionBackend()
  lazy val api = new CoingeckoApi()

  lazy val client = new CoingeckoClientImpl(api)

    Try {
      client.ping
    } match {
      case Success(value) =>
        value match {
          case Left(_) => println(s"Ping Failed")
          case Right(response) => println(s"${response.geckoSays}")
        }
      case Failure(exception) =>
        println(s"Failure ${exception.getMessage}")
    }

    Try {
      client.getPrice(List("bitcoin"), List("eth", "usd"))
    } match {
      case Success(value) =>
        value match {
          case  Left(c) => println(s"List Price failed ${c.code} reason ${c.error}")
          case Right(priceWithCurrencies) => println(s"Price ${priceWithCurrencies("bitcoin").mkString(",")}")
        }
      case Failure(exception) =>
        println(s"Failure ${exception.getMessage}")
    }

  println(s"Coingecko App End")
}
