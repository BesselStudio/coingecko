package com.besselstudio.coingecko.model.response

import play.api.libs.json.{JsonConfiguration, Json}
import play.api.libs.json.JsonNaming.SnakeCase

trait BaseResponse {
  given JsonConfiguration.Aux[Json.WithDefaultValues] = JsonConfiguration[Json.WithDefaultValues](naming = SnakeCase)
}
