package com.besselstudio.coingecko.model.coins.status

import com.besselstudio.coingecko.model.coins.common.Image
import play.api.libs.json.{Format, Json}

case class Project(
  `type`: String,
  id: String,
  name: String,
  symbol: String,
  image: Image
)

object Project {
  implicit val format: Format[Project] = Json.format[Project]
}
