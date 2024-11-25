package com.olvera.cryptotracker.crypto.data.networking

import com.olvera.cryptotracker.core.data.networking.constructUrl
import com.olvera.cryptotracker.core.data.networking.safeCall
import com.olvera.cryptotracker.core.domain.util.NetworkError
import com.olvera.cryptotracker.core.domain.util.Result
import com.olvera.cryptotracker.core.domain.util.map
import com.olvera.cryptotracker.crypto.data.mappers.toCoin
import com.olvera.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import com.olvera.cryptotracker.crypto.domain.Coin
import com.olvera.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/asseta")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }
}