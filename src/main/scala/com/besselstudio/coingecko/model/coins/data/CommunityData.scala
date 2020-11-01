package com.besselstudio.coingecko.model.coins.data

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class CommunityData(
  facebookLikes: Double,
  twitterFollowers: Double,
  redditAveragePosts48h: Double,
  redditAverageComments48h: Double,
  redditSubscribers: Double,
  redditAccountsActive48h: Double,
  telegramChannelUserCount: Double
)

object CommunityData extends BaseResponse {
  implicit val format: Format[CommunityData] = Json.format[CommunityData]
}
