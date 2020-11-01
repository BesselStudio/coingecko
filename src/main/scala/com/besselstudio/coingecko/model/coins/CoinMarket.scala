package com.besselstudio.coingecko.model.coins

import com.besselstudio.coingecko.model.coins.data.Roi
import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Json, Reads}

case class CoinMarket(
  id: String,
  symbol: String,
  name: String,
  image: String,
  currentPrice: Double,
  marketCap: Long,
  marketCapRank: Long,
  fullyDilutedValuation: Long,
  totalValue: Long,
  high24h: Double,
  low24h: Double,
  priceChange24h: Double,
  priceChangePercentage24h: Double,
  marketCapChange24h: Double,
  marketCapChangePercentage24h: Double,
  circulatingSupply: Long,
  totalSupply: Long,
  ath: Double,
  athChangePercentage: Double,
  athDate: String,
  roi: Roi,
  lastUpdated: String
)

object CoinMarket extends BaseResponse {
  implicit val coinMarketReads: Reads[CoinMarket] = Json.reads[CoinMarket]
}
