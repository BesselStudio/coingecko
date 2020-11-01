package com.besselstudio.coingecko.model.exchanges

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Json, Reads}

case class Rate(
  name: String,
  unit: String,
  value: Long,
  `type`: String
)

object Rate extends BaseResponse {
  implicit val reads: Reads[Rate] = Json.reads[Rate]
}
