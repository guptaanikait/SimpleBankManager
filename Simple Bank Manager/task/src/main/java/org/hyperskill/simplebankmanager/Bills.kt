package org.hyperskill.simplebankmanager

object Bills {
    var defaultBillInfoMap = mapOf(
        "ELEC" to Triple("Electricity", "ELEC", 45.0),
        "GAS" to Triple("Gas", "GAS", 20.0),
        "WTR" to Triple("Water", "WTR", 25.5)
    )
}