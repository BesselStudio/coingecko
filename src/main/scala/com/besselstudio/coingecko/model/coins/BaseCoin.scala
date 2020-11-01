package com.besselstudio.coingecko.model.coins

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Json, Reads}

case class BaseCoin(
  id: String,
  symbol: String,
  name: String
)

object BaseCoin extends BaseResponse{
  implicit val baseCoinReads: Reads[BaseCoin] = Json.reads[BaseCoin]
}
