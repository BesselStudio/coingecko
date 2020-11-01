package com.besselstudio.coingecko.model.events

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Json, Reads}

case class EventTypes(
  data: List[String],
  count: Long
)

object EventTypes extends BaseResponse {
  implicit val reads: Reads[EventTypes] = Json.reads[EventTypes]
}