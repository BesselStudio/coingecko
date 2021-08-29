package com.besselstudio.coingecko.model.coins.data

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class CodeAdditionsDeletions4Weeks(
  additions: Long,
  deletions: Long
)

object CodeAdditionsDeletions4Weeks extends BaseResponse {
  given Format[CodeAdditionsDeletions4Weeks] = Json.format[CodeAdditionsDeletions4Weeks]
}
