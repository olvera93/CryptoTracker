package com.olvera.cryptotracker.crypto.presentation.coin_list

import com.olvera.cryptotracker.crypto.presentation.models.CoinUi

sealed interface CoinListAction {

    data class OnCoinClick(val coinUi: CoinUi) : CoinListAction
}