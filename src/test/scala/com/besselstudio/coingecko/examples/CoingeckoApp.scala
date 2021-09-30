package com.besselstudio.coingecko.examples

import com.besselstudio.coingecko.{CoingeckoApi, CoingeckoApiError}
import com.besselstudio.coingecko.client.{CoingeckoApiBasic, CoingeckoApiClient}
import play.api.libs.json.{Format, JsError, JsSuccess, Json}
import sttp.client3.{HttpURLConnectionBackend, Identity, SttpBackend}

import scala.util.{Failure, Success, Try}

object CoingeckoApp extends App {
  println(s"Coingecko App Start")
  given SttpBackend[Identity, Any] = HttpURLConnectionBackend()
  lazy val api = CoingeckoApi[Identity, Any]()
  lazy val client = CoingeckoApiBasic(api)

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
        case Left(c) => println(s"List Price failed ${c.code} reason ${c.error}")
        case Right(priceWithCurrencies) => println(s"Price BTC ${priceWithCurrencies("bitcoin").mkString(",")}")
      }
    case Failure(exception) =>
      println(s"Failure ${exception.getMessage}")
  }

  Try {
    client.getCoinsList
  } match {
    case Success(payload) =>
      payload match {
        case Left(apiError) => println(s"Coins list failed ${apiError.code} reason ${apiError.error}")
        case Right(coins) => println(s"Coins List total ${coins.length} first 20 \n ${coins.filter(_.id.length < 10).slice(30, 50).map(_.id).mkString("\n")}")
      }
    case Failure(exception) =>
      println(s"Failure ${exception.getMessage}")
  }

  Try {
    client.getCoinHistoryById("aave", "30-12-2020")
  } match {
    case Success(response) =>
      response match {
        case Left(error) => print(s"api call failed ${error.code} reason ${error.error}")
        case Right(history) => println(s"Coin History circulating supply: ${history.marketData.flatMap(_.circulatingSupply).getOrElse("N/A")}")
      }
    case Failure(exception) =>
      println(s"Failure ${exception.getMessage}")
  }

  println(s"Coingecko App End")
}
