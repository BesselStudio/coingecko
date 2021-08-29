package com.besselstudio.coingecko.model.global

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class Global(
  global: Globaldata
)

object Global extends BaseResponse {
  given Format[Global] = Json.format[Global]
}