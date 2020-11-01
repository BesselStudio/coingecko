package com.besselstudio.coingecko.model.coins

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Json, Reads}

case class MarketChart(
  prices: List[List[String]],
  marketCaps: List[List[String]],
  totalVolumes: List[List[String]]
)

object MarketChart extends BaseResponse {
  implicit val reads: Reads[MarketChart] = Json.reads[MarketChart]
}
