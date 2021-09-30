package com.besselstudio.coingecko

import sttp.client3.{Identity, Response, SttpBackend, UriContext, basicRequest}
import sttp.model.QueryParams

class CoingeckoApi[F[_], P](using val backend: SttpBackend[F, P]) {
  def get(endpoint: String, params: QueryParams): F[Response[Either[String, String]]] = {
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
