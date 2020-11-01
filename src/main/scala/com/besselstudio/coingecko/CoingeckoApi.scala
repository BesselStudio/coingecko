package com.besselstudio.coingecko

import sttp.client.{Identity, NothingT, Response, SttpBackend, UriContext, basicRequest}
import sttp.model.QueryParams

class CoingeckoApi(implicit val backend: SttpBackend[Identity, Nothing, NothingT]) {
  def get(endpoint: String, params: QueryParams): Identity[Response[Either[String, String]]] = {
      val apiUrl = s"${CoingeckoApi.baseUrl}/$endpoint"
      println(uri"${apiUrl}"
        .params(params).toString())
      basicRequest
        .get(
          uri"$apiUrl"
            .params(params)
        )
        .send()
  }
}

object CoingeckoApi {
  lazy val baseUrl = "https://api.coingecko.com/api/v3"
}
