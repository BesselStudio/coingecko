package com.besselstudio.coingecko.model.exchanges

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class Rate(
  name: String,
  unit: String,
  value: Long,
  `type`: String
)

object Rate extends BaseResponse {
  given Format[Rate] = Json.format[Rate]
}
