package com.besselstudio.coingecko.model.response

import play.api.libs.json._

case class PingResponse(
  geckoSays: String
)

object PingResponse extends BaseResponse {
  implicit val pingReads: Reads[PingResponse] = Json.reads[PingResponse]
}


