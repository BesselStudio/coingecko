package com.besselstudio.coingecko.model.response

import play.api.libs.json.{Format, Json}

case class PingResponse(
  geckoSays: String
)

object PingResponse extends BaseResponse {
  given Format[PingResponse] = Json.format[PingResponse]
}


