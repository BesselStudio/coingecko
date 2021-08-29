package com.besselstudio.coingecko.model.events

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class EventCountryData(
  country: Option[String],
  code: String,
)

object EventCountryData  extends BaseResponse {
  given Format[EventCountryData] = Json.format[EventCountryData]
}
