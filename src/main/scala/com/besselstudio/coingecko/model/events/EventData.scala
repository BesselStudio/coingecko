package com.besselstudio.coingecko.model.events

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class EventData(
  `type`: String,
  title : String,
  description: String,
  organizer: String,
  startDate: String,
  endDate: String,
  website: String,
  email: String,
  venue: String,
  address: String,
  city: String,
  country: String,
  screenshot: String
)

object EventData  extends BaseResponse {
  implicit val format: Format[EventData] = Json.format[EventData]
}