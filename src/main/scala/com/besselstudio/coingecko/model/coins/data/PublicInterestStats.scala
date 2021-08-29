package com.besselstudio.coingecko.model.coins.data

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class PublicInterestStats(
  alexaRank: Option[Long],
  bingMatches: Option[Long]
)

object PublicInterestStats extends BaseResponse {
  given Format[PublicInterestStats] = Json.format[PublicInterestStats]
}
