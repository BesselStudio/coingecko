package com.besselstudio.coingecko.model.exchanges

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class BaseExchange(
  id: String,
  name: String
)

object BaseExchange  extends BaseResponse {
  implicit val format: Format[BaseExchange] = Json.format[BaseExchange]
}