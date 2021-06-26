package com.besselstudio.coingecko

import sttp.client3.{Identity, Response, SttpBackend, UriContext, basicRequest}
import sttp.model.QueryParams

class CoingeckoApi(implicit val backend: SttpBackend[Identity, Any]) {
  def get(endpoint: String, params: QueryParams): Identity[Response[Either[String, String]]] = {
      val apiUrl = s"${CoingeckoApi.baseUrl}/$endpoint"
      println(uri"${apiUrl}"
        .withParams(params).toString())
      basicRequest
        .get(
          uri"$apiUrl"
            .withParams(params)
        )
        .send(backend)
  }
}

object CoingeckoApi {
  lazy val baseUrl = "https://api.coingecko.com/api/v3"
}
