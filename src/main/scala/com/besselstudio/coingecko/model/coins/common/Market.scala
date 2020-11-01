package com.besselstudio.coingecko.model.coins.common

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Json, Format}

case class Market(
  name: String,
  identifier: String,
  hasTradingIncentive: Boolean
)

object Market extends BaseResponse {
  implicit val format: Format[Market] = Json.format[Market]
}
