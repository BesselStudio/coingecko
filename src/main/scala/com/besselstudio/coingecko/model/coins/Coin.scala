package com.besselstudio.coingecko.model.coins

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Json, Reads}

case class Coin(
  id: String
)

object Coin extends BaseResponse {
  implicit val reads: Reads[Coin] = Json.reads[Coin]
}
