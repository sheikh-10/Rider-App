package com.food.riderapp.data

import androidx.compose.material.icons.Icons
import com.food.riderapp.R
import com.food.riderapp.model.MenuOption

object Datasource {
    fun loadOptions(): List<MenuOption> {
        return listOf(
            MenuOption(optionImage = R.drawable.notes, optionName = "New Available"),
            MenuOption(optionImage = R.drawable.local_shipping, optionName = "Parcels In Progress"),
            MenuOption(optionImage = R.drawable.person, optionName = "Not Yet Delivered"),
            MenuOption(optionImage = R.drawable.done, optionName = "History"),
            MenuOption(optionImage = R.drawable.paid, optionName = "Total Earnings"),
            MenuOption(optionImage = R.drawable.logout, optionName = "Logout"),
        )
    }
}