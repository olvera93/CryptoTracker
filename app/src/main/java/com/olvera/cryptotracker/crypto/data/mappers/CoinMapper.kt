package com.olvera.cryptotracker.crypto.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.olvera.cryptotracker.crypto.data.networking.dto.CoinDto
import com.olvera.cryptotracker.crypto.data.networking.dto.CoinPriceDto
import com.olvera.cryptotracker.crypto.domain.Coin
import com.olvera.cryptotracker.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant.ofEpochMilli(time)
            .atZone(ZoneId.systemDefault())
    )
}