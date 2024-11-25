package com.olvera.cryptotracker.crypto.presentation.coin_list

import com.olvera.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {

    data class Error(val error: NetworkError): CoinListEvent

}