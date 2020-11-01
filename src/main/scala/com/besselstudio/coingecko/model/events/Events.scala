package com.besselstudio.coingecko.model.events

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class Events(
  data: List[EventData],
  count: Long,
  page: Long
)

object Events  extends BaseResponse  {
  implicit val format: Format[Events] = Json.format[Events]
}