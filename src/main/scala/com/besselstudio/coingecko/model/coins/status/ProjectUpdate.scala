package com.besselstudio.coingecko.model.coins.status

import com.besselstudio.coingecko.model.response.BaseResponse
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

object ProjectUpdate extends BaseResponse {
  given Format[ProjectUpdate] = Json.format[ProjectUpdate]
}