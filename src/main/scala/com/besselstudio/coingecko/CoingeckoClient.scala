package com.besselstudio.coingecko

import com.besselstudio.coingecko.model.coins.CoinPrice.CoinWithCurrencies
import com.besselstudio.coingecko.model.coins.status.ProjectUpdate
import com.besselstudio.coingecko.model.coins.{BaseCoin, Coin, CoinHistory, CoinMarket, CoinTicker, MarketChart}
import com.besselstudio.coingecko.model.events.{EventCountries, EventTypes, Events}
import com.besselstudio.coingecko.model.exchanges.{BaseExchange, Exchange, ExchangeRates, ExchangeTickers}
import com.besselstudio.coingecko.model.global.Global
import com.besselstudio.coingecko.model.response.PingResponse

trait CoingeckoClient {

  def ping: Either[CoingeckoApiError, PingResponse]

  def getPrice(
    ids: List[String],
    vsCurrencies: List[String],
  ): Either[CoingeckoApiError, CoinWithCurrencies]

  def getPrice(
    ids: List[String],
    vsCurrencies: List[String],
    includeMarketCap: Boolean,
    include24hrVol: Boolean,
    include24hrChange: Boolean,
    includeLastUpdateAt: Boolean
  ): Either[CoingeckoApiError, CoinWithCurrencies]


  def getTokenPrice(
    id: String,
    contractAddress: String,
    vsCurrencies: List[String]
  ): Either[CoingeckoApiError, CoinWithCurrencies]

  def getTokenPrice(
    id: String,
    contractAddress: String,
    vsCurrencies: List[String],
    includeMarketCap: Boolean,
    include24hrVol: Boolean,
    include24hrChange: Boolean,
    includeLastUpdateAt: Boolean
  ): Either[CoingeckoApiError, CoinWithCurrencies]

  def getSupportedVsCurrencies: Either[CoingeckoApiError, List[String]]

  def getCoinsList: Either[CoingeckoApiError, List[BaseCoin]]

  def getCoinMarkets(vsCurrency: String): Either[CoingeckoApiError, List[CoinMarket]]

  def getCoinMarkets(
    vsCurrency: String,
    ids: List[String],
    order: Option[String],
    perPage: Option[Int],
    page: Option[Int],
    sparkline: Option[Boolean],
    priceChangePercentage: Option[String]
  ): Either[CoingeckoApiError,List[CoinMarket]]

  def getCoinById(id: String): Either[CoingeckoApiError, Coin]

  def getCoinById(
    id: String,
    localization: Option[Boolean],
    tickers: Option[Boolean],
    marketData: Option[Boolean],
    communityData: Option[Boolean],
    developerData: Option[Boolean],
    sparkline: Option[Boolean]): Either[CoingeckoApiError, Coin]

  def getCoinTickerById(id: String): Either[CoingeckoApiError, CoinTicker]

  def getCoinTickerById(id: String, exchangeIds: List[String], page: Option[Int], order: Option[String]): Either[CoingeckoApiError, CoinTicker]

  def getCoinHistoryById(id: String, date: String): Either[CoingeckoApiError, CoinHistory]

  def getCoinHistoryById(id: String, date: String, localization: Option[Boolean]): Either[CoingeckoApiError, CoinHistory]

  def getCoinMarketChartById(id: String, vsCurrency: String, days: Int): Either[CoingeckoApiError, MarketChart]

  def getCoinMarketChartRangeById(id: String, vsCurrency: String, from: String, to: String): Either[CoingeckoApiError, MarketChart]

  def getCoinStatusUpdateById(id: String): Either[CoingeckoApiError, List[ProjectUpdate]]

  def getCoinStatusUpdateById(id: String, perPage: Option[Int], page: Option[Int]): Either[CoingeckoApiError, List[ProjectUpdate]]

  def getCoinInfoByContractAddress(id: String, contractAddress: String): Either[CoingeckoApiError, Coin]

  def getExchanges(perPage: Option[Int] = None, page: Option[String] = None): Either[CoingeckoApiError, List[Exchange]]

  def getExchangesList: Either[CoingeckoApiError, List[BaseExchange]]

  def getExchangesById(id: String): Either[CoingeckoApiError, Exchange]

  def getExchangesTickersById(id: String): Either[CoingeckoApiError, ExchangeTickers]

  def getExchangesTickersById(
    id: String,
    coinIds: List[String],
    page: Option[Int],
    order: Option[String]
  ): Either[CoingeckoApiError, ExchangeTickers]

  def getExchangesStatusUpdatesById(id: String): Either[CoingeckoApiError, List[ProjectUpdate]]

  def getExchangesStatusUpdatesById(id: String, perPage: Option[Int], page: Option[Int]): Either[CoingeckoApiError, List[ProjectUpdate]]

  def getExchangesVolumeChart(id: String, days: Int): Either[CoingeckoApiError, List[List[String]]]

  def getStatusUpdates: Either[CoingeckoApiError, List[ProjectUpdate]]

  def getStatusUpdates(
    category: Option[String],
    projectType: Option[String],
    perPage: Option[Int],
    page: Option[Int]
  ): Either[CoingeckoApiError, List[ProjectUpdate]]

  def getEvents: Either[CoingeckoApiError, Events]

  def getEvents(
    countryCode: Option[String],
    `type`: Option[String],
    page: Option[Int],
    upcomingEventsOnly: Option[Boolean],
    fromDate: Option[String],
    toDate: Option[String]
  ): Either[CoingeckoApiError, Events]

  def getEventsCountries: Either[CoingeckoApiError, EventCountries]

  def getEventsTypes: Either[CoingeckoApiError, EventTypes]

  def getExchangeRates: Either[CoingeckoApiError, ExchangeRates]

  def getGlobal: Either[CoingeckoApiError, Global]

}
