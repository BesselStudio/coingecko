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
  marketData: MarketData,
  communityData: CommunityData,
  developerData: DeveloperData,
  publicInterestStats: PublicInterestStats
)

object CoinHistory extends BaseResponse {
  implicit val format: Format[CoinHistory] = Json.format[CoinHistory]
}