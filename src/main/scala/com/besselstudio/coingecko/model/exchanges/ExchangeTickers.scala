package com.besselstudio.coingecko.model.exchanges

import com.besselstudio.coingecko.model.coins.common.Ticker
import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class ExchangeTickers(
  name: String,
  tickers: List[Ticker]
)


object ExchangeTickers  extends BaseResponse {
  implicit val format: Format[ExchangeTickers] = Json.format[ExchangeTickers]
}