package com.besselstudio.coingecko.model.coins.common

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class Market(
  name: String,
  identifier: String,
  hasTradingIncentive: Boolean
)

object Market extends BaseResponse {
  given Format[Market] = Json.format[Market]
}
