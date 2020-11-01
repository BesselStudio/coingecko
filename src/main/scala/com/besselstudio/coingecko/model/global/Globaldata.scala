package com.besselstudio.coingecko.model.global

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Json, Reads}

case class Globaldata(
  activeCryptocurrencies: Long,
  upcomingIcos: Long,
  ongoingIcos: Long,
  endedIcos: Long,
  markets: Long,
  totalMarketCap: Map[String, Double],
  totalVolume: Map[String, Double],
  marketCapPercentage: Map[String, Double],
  marketCapChangePercentage24hUsd: Double,
  updatedAt: String
)

object Globaldata extends BaseResponse {
  implicit val reads: Reads[Globaldata] = Json.reads[Globaldata]
}
