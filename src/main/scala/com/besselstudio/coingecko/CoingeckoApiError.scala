package com.besselstudio.coingecko

import play.api.libs.json.{Format, Json}

case class CoingeckoApiError(
  code: Int,
  error: String
)

object CoingeckoApiError {
  implicit lazy val format: Format[CoingeckoApiError] = Json.format[CoingeckoApiError]

  def internalApiError(message: Option[String] = None): CoingeckoApiError =
    CoingeckoApiError(500, s"${message.getOrElse("Coingecko Api Error")}")
}
