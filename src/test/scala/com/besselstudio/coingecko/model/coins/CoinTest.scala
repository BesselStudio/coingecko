package com.besselstudio.coingecko.model.coins

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CoinTest extends AnyWordSpec with Matchers {

  "A coin" should {
    "have an id" in {
      val bitcoin = Coin(id="bitcoin")

      assert(bitcoin.id == "bitcoin")
    }
  }

}
