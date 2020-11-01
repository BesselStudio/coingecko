package com.besselstudio.coingecko.model.coins.data

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json, Reads}

case class PublicInterestStats(
  alexaRank: Long,
  bingMatches: Long
)

object PublicInterestStats extends BaseResponse {
  implicit val format: Format[PublicInterestStats] = Json.format[PublicInterestStats]
}
