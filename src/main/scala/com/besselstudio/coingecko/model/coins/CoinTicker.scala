package com.besselstudio.coingecko.model.coins

import com.besselstudio.coingecko.model.coins.common.Ticker
import play.api.libs.json.{Json, Reads}

case class CoinTicker(
  name: String,
  tickers: List[Ticker]
)

object CoinTicker {
  implicit val reads: Reads[CoinTicker] = Json.reads[CoinTicker]
}