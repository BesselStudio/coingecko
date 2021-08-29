package com.besselstudio.coingecko.model.coins.common

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class Image(
  thumb: Option[String],
  small: Option[String],
  large: Option[String]
)

object Image extends BaseResponse {
  given Format[Image] = Json.format[Image]
}
