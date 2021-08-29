package com.besselstudio.coingecko.model.coins.data

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class MarketData(
  currentPrice: Map[String, Double],
  roi: Option[Roi],
  ath: Option[Map[String, Double]],
  athChangePercentage: Option[Map[String, Double]],
  athDate: Option[Map[String, String]],
  marketCap: Option[Map[String, Double]],
  marketCapRank: Option[Long],
  totalVolume: Option[Map[String, Double]],
  priceChangePercentage24h: Option[Double],
  priceChangePercentage7d: Option[Double],
  priceChangePercentage14d: Option[Double],
  priceChangePercentage30d: Option[Double],
  priceChangePercentage60d: Option[Double],
  priceChangePercentage200d: Option[Double],
  priceChangePercentage1y: Option[Double],
  marketCapChange24h: Option[Double],
  marketCapChangePercentage24h: Option[Double],
  priceChange24hInCurrency: Option[Map[String, Double]],
  priceChangePercentage1hInCurrency: Option[Map[String, Double]],
  priceChangePercentage24hInCurrency: Option[Map[String, Double]],
  priceChangePercentage7dInCurrency: Option[Map[String, Double]],
  priceChangePercentage14dInCurrency: Option[Map[String, Double]],
  priceChangePercentage30dInCurrency: Option[Map[String, Double]],
  priceChangePercentage60dInCurrency: Option[Map[String, Double]],
  priceChangePercentage200dInCurrency: Option[Map[String, Double]],
  priceChangePercentage1yInCurrency: Option[Map[String, Double]],
  marketCapChange24hInCurrency: Option[Map[String, Double]],
  marketCapChangePercentage24hInCurrency: Option[Map[String, Double]],
  totalSupply: Option[Long],
  circulatingSupply: Option[Double],
  lastUpdated: Option[String]
)

object MarketData extends BaseResponse {
  given Format[MarketData] = Json.format[MarketData]
}