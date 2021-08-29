Scala Coingecko API
===================

The Scala API for coingecko that you always wanted.

Welcome!

[coingecko-api](https://github.com/BesselStudio/coingecko) is an open-source library which implements Coingecko API. 
It uses the great [sttp client](https://github.com/softwaremill/sttp) to interact with the API, so you have access to
any backend that sttp supports.

## Setup with sbt

Add the following dependency:
Scala 3
```scala
"com.besselstudio.coingecko" %% "client" % "3.0.0"
```

Scala 2, we will backport updates in the branch 2.x
```scala
"com.besselstudio.coingecko" %% "client" % "0.2.0"
```

Then, import:

```scala
import sttp.client3._
```

Here is a quick example of coingecko api:

```scala
import com.besselstudio.coingecko.CoingeckoApi
import com.besselstudio.coingecko.client.CoingeckoClientImpl
import sttp.client3.{HttpURLConnectionBackend, Identity, SttpBackend}

import scala.util.{Failure, Success, Try}

object CoingeckoApp extends App {
  println(s"Coingecko App Start")
  given backend: SttpBackend[Identity, Any] = HttpURLConnectionBackend()
  lazy val api = new CoingeckoApi()

  lazy val client = new CoingeckoClientImpl(api)

    Try {
      client.getPrice(List("bitcoin"), List("eth", "usd"))
    } match {
      case Success(value) =>
        value match {
          case  Left(c) => println(s"List Price failed ${c.code} reason ${c.error}")
          case Right(priceWithCurrencies) => println(s"Price BTC ${priceWithCurrencies("bitcoin").mkString(",")}")
        }
      case Failure(exception) =>
        println(s"Failure ${exception.getMessage}")
    }

  println(s"Coingecko App End")
}
```