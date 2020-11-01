package com.besselstudio.coingecko.model.events

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class EventCountryData(
  country: Option[String],
  code: String,
)

object EventCountryData  extends BaseResponse {
  implicit val format: Format[EventCountryData] = Json.format[EventCountryData]
}
