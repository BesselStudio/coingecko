package com.besselstudio.coingecko.model.events

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class EventCountries(
  data: List[EventCountryData],
  count: String
)

object EventCountries  extends BaseResponse {
  given Format[EventCountries] = Json.format[EventCountries]
}
