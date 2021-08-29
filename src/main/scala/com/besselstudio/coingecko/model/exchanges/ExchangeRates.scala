package com.besselstudio.coingecko.model.exchanges

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class ExchangeRates(
  rates: Map[String, Rate]
)

object ExchangeRates extends BaseResponse {
  given Format[ExchangeRates] = Json.format[ExchangeRates]
}
