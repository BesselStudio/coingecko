package com.besselstudio.coingecko.model.coins

import com.besselstudio.coingecko.model.coins.common.Image
import com.besselstudio.coingecko.model.coins.data.{CommunityData, DeveloperData, MarketData, PublicInterestStats}
import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class CoinHistory(
  id: String,
  symbol: String,
  name: String,
  localization: Map[String, String],
  image: Image,
  marketData: Option[MarketData],
  communityData: Option[CommunityData],
  developerData: Option[DeveloperData],
  publicInterestStats: Option[PublicInterestStats]
)

object CoinHistory extends BaseResponse {
  given Format[CoinHistory] = Json.format[CoinHistory]
}