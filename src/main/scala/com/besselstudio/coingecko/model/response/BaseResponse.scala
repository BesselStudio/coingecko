package com.besselstudio.coingecko.model.response

import play.api.libs.json.{Json, JsonConfiguration}
import play.api.libs.json.JsonConfiguration.Aux
import play.api.libs.json.JsonNaming.SnakeCase

trait BaseResponse {
  implicit val config: Aux[Json.MacroOptions] = JsonConfiguration(SnakeCase)
}
