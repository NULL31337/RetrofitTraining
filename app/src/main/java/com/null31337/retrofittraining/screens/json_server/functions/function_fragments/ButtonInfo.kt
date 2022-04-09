package com.null31337.retrofittraining.screens.json_server.functions.function_fragments

import androidx.navigation.NavDirections
import com.null31337.retrofittraining.APP

abstract class ButtonInfo(
    val name: String,
) {
    abstract fun navigate()
}

class ButtonInfoId(
    name: String,
    private val navigation: Int
) : ButtonInfo(name) {
    override fun navigate() {
        APP.navController.navigate(navigation)
    }
}

class ButtonInfoNavigation(
    name: String,
    private val navigation: NavDirections
) : ButtonInfo(name) {
    override fun navigate() {
        APP.navController.navigate(navigation)
    }
}
