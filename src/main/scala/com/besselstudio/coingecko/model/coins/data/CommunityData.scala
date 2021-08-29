package com.besselstudio.coingecko.model.coins.data

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class CommunityData(
  facebookLikes: Option[Double],
  twitterFollowers: Option[Double],
  redditAveragePosts48h: Option[Double],
  redditAverageComments48h: Option[Double],
  redditSubscribers: Option[Double],
  redditAccountsActive48h: Option[Double],
  telegramChannelUserCount: Option[Double]
)

object CommunityData extends BaseResponse {
  given Format[CommunityData] = Json.format[CommunityData]
}
