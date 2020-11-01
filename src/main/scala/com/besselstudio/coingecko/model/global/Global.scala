package com.besselstudio.coingecko.model.global

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Json, Reads}

case class Global(
  global: Globaldata
)

object Global extends BaseResponse {
  implicit val reads: Reads[Global] = Json.reads[Global]
}