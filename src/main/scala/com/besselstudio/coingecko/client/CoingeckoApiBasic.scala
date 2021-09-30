package com.besselstudio.coingecko.client

import com.besselstudio.coingecko.client.CoingeckoApiClient
import com.besselstudio.coingecko.{CoingeckoApi, CoingeckoApiError}
import play.api.libs.json.{Format, JsError, JsSuccess, Json}
import sttp.client3.{Identity, SttpBackend}
import sttp.model.QueryParams

class CoingeckoApiBasic(api: CoingeckoApi[Identity, Any]) extends CoingeckoApiClient {
  def get[T](endpoint: String, queryParams: QueryParams)(using Format[T]): Either[CoingeckoApiError, T] =
    api.get(endpoint, queryParams).body match {
      case Left(json) =>
        Json.parse(json).validate[CoingeckoApiError] match {
          case JsSuccess(value, _) => Left(value)
          case JsError(errors) =>
            Left(CoingeckoApiError.internalApiError(Some("Unknown Api Error")))
        }

      case Right(json) =>
        Json.parse(json).validate[T] match {
          case JsSuccess(value, _) =>
            Right(value)
          case JsError(errors) =>
            Left(
              CoingeckoApiError
                .internalApiError(Some(s"Invalid Response for $endpoint"))
            )
        }
    }
}
