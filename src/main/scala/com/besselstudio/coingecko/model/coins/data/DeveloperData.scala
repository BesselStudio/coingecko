package com.besselstudio.coingecko.model.coins.data

import com.besselstudio.coingecko.model.response.BaseResponse
import play.api.libs.json.{Format, Json}

case class DeveloperData(
  forks: Long,
  stars: Long,
  subscribers: Long,
  totalIssues: Long,
  closedIssues: Long,
  pullRequestsMerged: Long,
  pullRequestContributors: Long,
  codeAdditionsDeletions4Weeks: CodeAdditionsDeletions4Weeks,
  commitCount4Weeks: Long,
  last4WeeksCommitActivitySeries: List[Long]
)

object DeveloperData extends BaseResponse {
  implicit val format: Format[DeveloperData] = Json.format[DeveloperData]
}
