package com.olvera.cryptotracker.crypto.domain

import com.olvera.cryptotracker.core.domain.util.NetworkError
import com.olvera.cryptotracker.core.domain.util.Result

interface CoinDataSource {

    suspend fun getCoins(): Result<List<Coin>, NetworkError>

}