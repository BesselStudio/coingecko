package com.besselstudio.coingecko.model.coins.common

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json, Reads}

case class Image(
  thumb: String,
  small: String,
  large: String
)

object Image extends BaseResponse {
  implicit val format: Format[Image] = Json.format[Image]
}
