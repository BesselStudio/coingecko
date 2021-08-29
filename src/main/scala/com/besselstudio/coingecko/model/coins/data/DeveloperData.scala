package com.besselstudio.coingecko.model.coins.data

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class DeveloperData(
  forks: Long,
  stars: Long,
  subscribers: Option[Long],
  totalIssues: Option[Long],
  closedIssues: Option[Long],
  pullRequestsMerged: Option[Long],
  pullRequestContributors: Option[Long],
  codeAdditionsDeletions4Weeks: Option[CodeAdditionsDeletions4Weeks],
  commitCount4Weeks: Option[Long],
  last4WeeksCommitActivitySeries: Option[List[Long]]
)

object DeveloperData extends BaseResponse {
  given Format[DeveloperData] = Json.format[DeveloperData]
}
