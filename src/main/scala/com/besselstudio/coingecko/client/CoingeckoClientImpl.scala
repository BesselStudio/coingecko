package com.besselstudio.coingecko.client

import com.besselstudio.coingecko.model.coins.CoinPrice.CoinWithCurrencies
import com.besselstudio.coingecko.{
  CoingeckoApi,
  CoingeckoApiError,
  CoingeckoClient
}
import com.besselstudio.coingecko.model.coins.status.ProjectUpdate
import com.besselstudio.coingecko.model.coins.{
  BaseCoin,
  Coin,
  CoinHistory,
  CoinMarket,
  CoinTicker,
  MarketChart
}
import com.besselstudio.coingecko.model.events.{
  EventCountries,
  EventTypes,
  Events
}
import com.besselstudio.coingecko.model.exchanges.{
  BaseExchange,
  Exchange,
  ExchangeRates,
  ExchangeTickers
}
import com.besselstudio.coingecko.model.global.Global
import com.besselstudio.coingecko.model.response.PingResponse
import play.api.libs.json.{JsError, JsSuccess, Json, Reads}
import sttp.model.QueryParams

class CoingeckoClientImpl(
    api: CoingeckoApi
) extends CoingeckoClient {

  override def ping: Either[CoingeckoApiError, PingResponse] =
    get[PingResponse](endpoint = "ping", QueryParams())

  override def getPrice(
      ids: List[String],
      vsCurrencies: List[String]
  ): Either[CoingeckoApiError, CoinWithCurrencies] =
    getPrice(
      ids,
      vsCurrencies,
      includeMarketCap = false,
      include24hrVol = false,
      include24hrChange = false,
      includeLastUpdateAt = false
    )

  override def getPrice(
      ids: List[String],
      vsCurrencies: List[String],
      includeMarketCap: Boolean,
      include24hrVol: Boolean,
      include24hrChange: Boolean,
      includeLastUpdateAt: Boolean
  ): Either[CoingeckoApiError, CoinWithCurrencies] = {
    def buildQuery: Map[String, String] =
      Map(
        "ids" -> ids.mkString(","),
        "vs_currencies" -> vsCurrencies.mkString(","),
        "include_market_cap" -> includeMarketCap,
        "include_24hr_vol" -> include24hrVol,
        "include_24hr_change" -> include24hrChange,
        "include_last_updated_at" -> includeLastUpdateAt
      ).map(kv => (kv._1, kv._2.toString))

    get[CoinWithCurrencies](
      endpoint = "simple/price",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getTokenPrice(
      id: String,
      contractAddress: String,
      vsCurrencies: List[String]
  ): Either[CoingeckoApiError, CoinWithCurrencies] =
    getTokenPrice(
      id,
      contractAddress,
      vsCurrencies,
      includeMarketCap = false,
      include24hrVol = false,
      include24hrChange = false,
      includeLastUpdateAt = false
    )

  override def getTokenPrice(
      id: String,
      contractAddress: String,
      vsCurrencies: List[String],
      includeMarketCap: Boolean,
      include24hrVol: Boolean,
      include24hrChange: Boolean,
      includeLastUpdateAt: Boolean
  ): Either[CoingeckoApiError, CoinWithCurrencies] = {
    def buildQuery: Map[String, String] =
      Map(
        "contact_address" -> contractAddress,
        "include_market_cap" -> includeMarketCap,
        "include_24hr_vol" -> include24hrVol,
        "include_24hr_change" -> include24hrChange,
        "include_last_updated_at" -> includeLastUpdateAt
      ).map(kv => (kv._1, kv._2.toString))

    get[CoinWithCurrencies](
      endpoint = "simple/token_price",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getSupportedVsCurrencies
      : Either[CoingeckoApiError, List[String]] =
    get[List[String]](
      endpoint = "simple/supported_vs_currencies",
      QueryParams()
    )

  override def getCoinsList: Either[CoingeckoApiError, List[BaseCoin]] =
    get[List[BaseCoin]](endpoint = "coins/list", QueryParams())

  override def getCoinMarkets(
      vsCurrency: String
  ): Either[CoingeckoApiError, List[CoinMarket]] =
    getCoinMarkets(
      vsCurrency,
      ids = List.empty,
      order = None,
      perPage = None,
      page = None,
      sparkline = None,
      priceChangePercentage = None
    )

  override def getCoinMarkets(
      vsCurrency: String,
      ids: List[String],
      order: Option[String],
      perPage: Option[Int],
      page: Option[Int],
      sparkline: Option[Boolean],
      priceChangePercentage: Option[String]
  ): Either[CoingeckoApiError, List[CoinMarket]] = {
    def buildQuery: Map[String, String] =
      Map(
        "vs_currency" -> Some(vsCurrency),
        "ids" -> ids.reduceLeftOption((left, right) => s"$left,$right"),
        "order" -> order,
        "per_page" -> perPage.map(_.toString),
        "page" -> page.map(_.toString),
        "sparkline" -> sparkline.map(_.toString),
        "price_change_percentage" -> priceChangePercentage
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[List[CoinMarket]](
      endpoint = "coins/markets",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getCoinById(id: String): Either[CoingeckoApiError, Coin] =
    getCoinById(
      id,
      localization = None,
      tickers = None,
      marketData = None,
      communityData = None,
      developerData = None,
      sparkline = None
    )

  override def getCoinById(
      id: String,
      localization: Option[Boolean],
      tickers: Option[Boolean],
      marketData: Option[Boolean],
      communityData: Option[Boolean],
      developerData: Option[Boolean],
      sparkline: Option[Boolean]
  ): Either[CoingeckoApiError, Coin] = {

    def buildQuery: Map[String, String] =
      Map(
        "localization" -> localization.map(_.toString),
        "tickers" -> tickers.map(_.toString),
        "market_data" -> marketData.map(_.toString),
        "community_data" -> communityData.map(_.toString),
        "developer_data" -> developerData.map(_.toString),
        "sparkline" -> sparkline.map(_.toString)
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[Coin](endpoint = s"coins/$id", QueryParams.fromMap(buildQuery))
  }

  override def getCoinTickerById(
      id: String
  ): Either[CoingeckoApiError, CoinTicker] =
    getCoinTickerById(id, exchangeIds = List.empty, page = None, order = None)

  override def getCoinTickerById(
      id: String,
      exchangeIds: List[String],
      page: Option[Int],
      order: Option[String]
  ): Either[CoingeckoApiError, CoinTicker] = {
    def buildQuery =
      Map(
        "exchangeIds" -> exchangeIds.reduceLeftOption((left, right) =>
          s"$left,$right"
        )
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[CoinTicker](
      endpoint = s"coins/$id/tickers",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getCoinHistoryById(
      id: String,
      date: String
  ): Either[CoingeckoApiError, CoinHistory] =
    getCoinHistoryById(id, date, localization = None)

  override def getCoinHistoryById(
      id: String,
      date: String,
      localization: Option[Boolean]
  ): Either[CoingeckoApiError, CoinHistory] = {
    def buildQuery =
      Map(
        "localization" -> localization.map(_.toString)
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[CoinHistory](
      endpoint = s"coins/$id/history",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getCoinMarketChartById(
      id: String,
      vsCurrency: String,
      days: Int
  ): Either[CoingeckoApiError, MarketChart] = {
    def buildQuery =
      Map(
        "vs_currency" -> vsCurrency,
        "days" -> days.toString
      )
    get[MarketChart](
      endpoint = s"coins/$id/market_chart",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getCoinMarketChartRangeById(
      id: String,
      vsCurrency: String,
      from: String,
      to: String
  ): Either[CoingeckoApiError, MarketChart] = {
    def buildQuery =
      Map(
        "vs_currency" -> vsCurrency,
        "from" -> from,
        "to" -> to
      )

    get[MarketChart](
      endpoint = s"coins/$id/market_chart/range",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getCoinStatusUpdateById(
      id: String
  ): Either[CoingeckoApiError, List[ProjectUpdate]] =
    getCoinStatusUpdateById(id, perPage = None, page = None)

  override def getCoinStatusUpdateById(
      id: String,
      perPage: Option[Int],
      page: Option[Int]
  ): Either[CoingeckoApiError, List[ProjectUpdate]] = {
    def buildQuery =
      Map(
        "per_page" -> perPage.map(_.toString),
        "page" -> page.map(_.toString)
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[List[ProjectUpdate]](
      endpoint = s"coins/$id/status_updates",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getCoinInfoByContractAddress(
      id: String,
      contractAddress: String
  ): Either[CoingeckoApiError, Coin] =
    get[Coin](endpoint = s"coins/$id/contract/$contractAddress", QueryParams())

//  override def getExchanges(perPage: Option[Int] = None, page: Option[String] = None): Either[CoingeckoApiError, List[Exchange]] = ???
  override def getExchanges(
      perPage: Option[Int] = None,
      page: Option[String] = None
  ): Either[CoingeckoApiError, List[Exchange]] = {
    def buildQuery =
      Map(
        "per_page" -> perPage.map(_.toString),
        "page" -> page
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[List[Exchange]](
      endpoint = s"exchanges",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getExchangesList: Either[CoingeckoApiError, List[BaseExchange]] =
    get[List[BaseExchange]](endpoint = s"exchanges/list", QueryParams())
  override def getExchangesById(
      id: String
  ): Either[CoingeckoApiError, Exchange] =
    get[Exchange](endpoint = s"exchanges/$id", QueryParams())

  override def getExchangesTickersById(
      id: String
  ): Either[CoingeckoApiError, ExchangeTickers] =
    getExchangesTickersById(id, coinIds = List.empty, page = None, order = None)

  override def getExchangesTickersById(
      id: String,
      coinIds: List[String],
      page: Option[Int],
      order: Option[String]
  ): Either[CoingeckoApiError, ExchangeTickers] = {
    def buildQuery =
      Map(
        "coinIds" -> coinIds.reduceLeftOption((left, right) => s"$left,$right"),
        "page" -> page.map(_.toString),
        "order" -> order
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[ExchangeTickers](
      endpoint = s"exchange/$id/tickers",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getExchangesStatusUpdatesById(
      id: String
  ): Either[CoingeckoApiError, List[ProjectUpdate]] =
    getExchangesStatusUpdatesById(id, perPage = None, page = None)

  override def getExchangesStatusUpdatesById(
      id: String,
      perPage: Option[Int],
      page: Option[Int]
  ): Either[CoingeckoApiError, List[ProjectUpdate]] = {
    def buildQuery =
      Map(
        "per_page" -> perPage.map(_.toString),
        "page" -> page.map(_.toString)
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[List[ProjectUpdate]](
      endpoint = s"exchanges/$id/status_updates",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getExchangesVolumeChart(
      id: String,
      days: Int
  ): Either[CoingeckoApiError, List[List[String]]] = {
    def buildQuery =
      Map(
        "days" -> days.toString
      )

    get[List[List[String]]](
      endpoint = s"exchanges/$id/volume_chart",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getStatusUpdates
      : Either[CoingeckoApiError, List[ProjectUpdate]] =
    getStatusUpdates(
      category = None,
      projectType = None,
      perPage = None,
      page = None
    )

  override def getStatusUpdates(
      category: Option[String],
      projectType: Option[String],
      perPage: Option[Int],
      page: Option[Int]
  ): Either[CoingeckoApiError, List[ProjectUpdate]] = {
    def buildQuery =
      Map(
        "category" -> category,
        "project_type" -> projectType,
        "per_page" -> perPage.map(_.toString),
        "page" -> page.map(_.toString)
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[List[ProjectUpdate]](
      endpoint = "status_updates",
      QueryParams.fromMap(buildQuery)
    )
  }

  override def getEvents: Either[CoingeckoApiError, Events] =
    getEvents(
      countryCode = None,
      `type` = None,
      page = None,
      upcomingEventsOnly = None,
      fromDate = None,
      toDate = None
    )

  override def getEvents(
      countryCode: Option[String],
      `type`: Option[String],
      page: Option[Int],
      upcomingEventsOnly: Option[Boolean],
      fromDate: Option[String],
      toDate: Option[String]
  ): Either[CoingeckoApiError, Events] = {
    def buildQuery =
      Map(
        "country_code" -> countryCode,
        "type" -> `type`,
        "page" -> page.map(_.toString),
        "upcoming_events_only" -> upcomingEventsOnly.map(_.toString),
        "from_date" -> fromDate,
        "to_date" -> toDate
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[Events](endpoint = "events", QueryParams.fromMap(buildQuery))
  }

  override def getEventsCountries: Either[CoingeckoApiError, EventCountries] =
    get[EventCountries](endpoint = "event/countries", QueryParams())

  override def getEventsTypes: Either[CoingeckoApiError, EventTypes] =
    get[EventTypes](endpoint = "events/types", QueryParams())

  override def getExchangeRates: Either[CoingeckoApiError, ExchangeRates] =
    get[ExchangeRates](endpoint = "exchange_rates", QueryParams())

  override def getGlobal: Either[CoingeckoApiError, Global] =
    get[Global](endpoint = "global", QueryParams())

  def get[T](endpoint: String, queryParams: QueryParams)(
      implicit reads: Reads[T]
  ): Either[CoingeckoApiError, T] =
    api.get(endpoint, queryParams).body match {
      case Left(json) =>
        Json.parse(json).validate[CoingeckoApiError] match {
          case JsSuccess(value, _) => Left(value)
          case JsError(errors) =>
            Left(CoingeckoApiError.internalApiError(Some("Unknown Api Error")))
        }

      case Right(json) =>
        Json.parse(json).validate[T] match {
          case JsSuccess(value, _) => Right(value)
          case JsError(errors) =>
            Left(
              CoingeckoApiError
                .internalApiError(Some(s"Invalid Response for $endpoint"))
            )
        }
    }
}
