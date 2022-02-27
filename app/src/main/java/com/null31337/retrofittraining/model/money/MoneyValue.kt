package com.null31337.retrofittraining.model.money

import kotlinx.serialization.Serializable

@Serializable
data class MoneyValue(
    val AUD: MoneyItem,
    val AZN: MoneyItem,
    val GBP: MoneyItem,
    val AMD: MoneyItem,
    val BYN: MoneyItem,
    val BGN: MoneyItem,
    val BRL: MoneyItem,
    val HUF: MoneyItem,
    val HKD: MoneyItem,
    val USD: MoneyItem,
    val EUR: MoneyItem,
    val INR: MoneyItem,
    val KZT: MoneyItem,
    val CAD: MoneyItem,
    val KGS: MoneyItem,
    val CNY: MoneyItem,
    val NOK: MoneyItem,
    val PLN: MoneyItem,
    val RON: MoneyItem,
    val XDR: MoneyItem,
    val SGD: MoneyItem,
    val TJS: MoneyItem,
    val TRY: MoneyItem,
    val TMT: MoneyItem,
    val UZS: MoneyItem,
    val UAH: MoneyItem,
    val CZK: MoneyItem,
    val SEK: MoneyItem,
    val CHF: MoneyItem,
    val ZAR: MoneyItem,
    val KRW: MoneyItem,
    val JPY: MoneyItem
)