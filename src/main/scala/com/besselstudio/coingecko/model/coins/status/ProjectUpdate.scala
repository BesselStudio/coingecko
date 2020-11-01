package com.besselstudio.coingecko.model.coins.status

import play.api.libs.json.{Format, Json}

case class ProjectUpdate(
  description: String,
  category: String,
  createdAt: String,
  user: String,
  userTitle: String,
  pin: Boolean,
  project: Project
)

object ProjectUpdate {
  implicit val format: Format[ProjectUpdate] = Json.format[ProjectUpdate]
}