package com.besselstudio.coingecko

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class CoingeckoApiError(
  code: Int,
  error: String
)

object CoingeckoApiError extends BaseResponse {
  given Format[CoingeckoApiError] = Json.format[CoingeckoApiError]

  def internalApiError(message: Option[String] = None): CoingeckoApiError =
    CoingeckoApiError(500, s"${message.getOrElse("Coingecko Api Error")}")
}
