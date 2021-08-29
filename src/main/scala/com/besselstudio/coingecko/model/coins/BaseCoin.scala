package com.besselstudio.coingecko.model.coins

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class BaseCoin(
  id: String,
  symbol: String,
  name: String
)

object BaseCoin extends BaseResponse {
  given Format[BaseCoin] = Json.format[BaseCoin]
}
