package org.hyperskill.simplebankmanager

object ExchangeObj {
    var defaultMap = mapOf(
        "EUR" to mapOf(
            "GBP" to 0.5,
            "USD" to 2.0
        ),
        "GBP" to mapOf(
            "EUR" to 2.0,
            "USD" to 4.0
        ),
        "USD" to mapOf(
            "EUR" to 0.5,
            "GBP" to 0.25
        )
    )
    var fromcurr="EUR"
    var tocurr="GBP"
}