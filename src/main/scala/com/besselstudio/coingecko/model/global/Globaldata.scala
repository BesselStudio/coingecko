package com.besselstudio.coingecko.model.global

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

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
  given Format[Globaldata] = Json.format[Globaldata]
}
