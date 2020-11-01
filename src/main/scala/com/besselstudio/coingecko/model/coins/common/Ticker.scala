package com.besselstudio.coingecko.model.coins.common

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class Ticker(
  base: String,
  target: String,
  market: Market,
  last: Double,
  volume: Double,
  convertedLast: Map[String, String],
  convertedVolume: Map[String, String],
  trustScore: String,
  bidAskSpreadPercentage: Double,
  timestamp: String,
  lastTradedAt: String,
  lastFetchAt: String,
  isAnomaly: Boolean,
  isStale: Boolean,
  tradeUrl: String,
  coinId: String
)

object Ticker extends BaseResponse {
  implicit val format: Format[Ticker] = Json.format[Ticker]
}

