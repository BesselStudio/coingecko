package com.besselstudio.coingecko.model.events

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class EventTypes(
  data: List[String],
  count: Long
)

object EventTypes extends BaseResponse {
  given Format[EventTypes] = Json.format[EventTypes]
}