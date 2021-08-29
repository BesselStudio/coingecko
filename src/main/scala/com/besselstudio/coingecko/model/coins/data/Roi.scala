package com.besselstudio.coingecko.model.coins.data

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class Roi(
  times: Double,
  currency: String,
  percentage: Double
)

object Roi  extends BaseResponse {
  given Format[Roi] = Json.format[Roi]
}