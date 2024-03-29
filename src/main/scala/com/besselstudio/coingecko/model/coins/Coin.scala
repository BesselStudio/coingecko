package com.besselstudio.coingecko.model.coins

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class Coin(
  id: String
)

object Coin extends BaseResponse {
  given Format[Coin] = Json.format[Coin]
}
