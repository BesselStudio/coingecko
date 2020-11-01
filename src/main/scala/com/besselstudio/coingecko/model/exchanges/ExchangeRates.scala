package com.besselstudio.coingecko.model.exchanges

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Json, Reads}

case class ExchangeRates(
  rates: Map[String, Rate]
)

object ExchangeRates extends BaseResponse {
  implicit val reads: Reads[ExchangeRates] = Json.reads[ExchangeRates]
}
