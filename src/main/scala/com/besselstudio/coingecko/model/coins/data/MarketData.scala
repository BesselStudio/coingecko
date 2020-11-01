package com.besselstudio.coingecko.model.coins.data

import ai.x.play.json.{CamelToSnakeNameEncoder, Jsonx, NameEncoder}
import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Json, OFormat}

case class MarketData(
  currentPrice: Map[String, Double],
  roi: Roi,
  ath: Map[String, Double],
  athChangePercentage: Map[String, Double],
  athDate: Map[String, String],
  marketCap: Map[String, Double],
  marketCapRank: Long,
  totalVolume: Map[String, Double],
  priceChangePercentage24h: Double,
  priceChangePercentage7d: Double,
  priceChangePercentage14d: Double,
  priceChangePercentage30d: Double,
  priceChangePercentage60d: Double,
  priceChangePercentage200d: Double,
  priceChangePercentage1y: Double,
  marketCapChange24h: Double,
  marketCapChangePercentage24h: Double,
  priceChange24hInCurrency: Map[String, Double],
  priceChangePercentage1hInCurrency: Map[String, Double],
  priceChangePercentage24hInCurrency: Map[String, Double],
  priceChangePercentage7dInCurrency: Map[String, Double],
  priceChangePercentage14dInCurrency: Map[String, Double],
  priceChangePercentage30dInCurrency: Map[String, Double],
  priceChangePercentage60dInCurrency: Map[String, Double],
  priceChangePercentage200dInCurrency: Map[String, Double],
  priceChangePercentage1yInCurrency: Map[String, Double],
  marketCapChange24hInCurrency: Map[String, Double],
  marketCapChangePercentage24hInCurrency: Map[String, Double],
  totalSupply: Long,
  circulatingSupply: Double,
  lastUpdated: String
)

object MarketData extends BaseResponse {
  implicit val encoder: NameEncoder = CamelToSnakeNameEncoder()
  implicit lazy val format: OFormat[MarketData] = Jsonx.formatCaseClass[MarketData]
}