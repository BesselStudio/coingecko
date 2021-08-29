package com.besselstudio.coingecko.model.exchanges

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class Exchange(
  id: String,
  name: String,
  yearEstablished: String,
  country: String,
  description: String,
  url: String,
  image: String,
  hasTradingIncentive: Boolean,
  tradeVolume24hBtc: Double,
  facebookUrl: Option[String],
  redditUrl: Option[String],
  telegramUrl: Option[String],
  slackUrl: Option[String],
  otherUrl1: Option[String],
  otherUrl2: Option[String],
  twitterHandle: Option[String],
  centralized: Option[Boolean],
  publicNotice: Option[String],
  alertNotice: Option[String],
  trustScore: Option[Int],
  trustScoreRank: Option[Int],
  tradeVolume24hBtcNormalized: Option[Double],
  tickers: Option[List[ExchangeTickers]]
)

object Exchange extends BaseResponse {
  given Format[Exchange] = Json.format[Exchange]
}