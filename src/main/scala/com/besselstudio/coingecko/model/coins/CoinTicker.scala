package com.besselstudio.coingecko.model.coins

import com.besselstudio.coingecko.model.coins.common.Ticker
import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class CoinTicker(
  name: String,
  tickers: List[Ticker]
)

object CoinTicker extends BaseResponse {
  given Format[CoinTicker] = Json.format[CoinTicker]
}