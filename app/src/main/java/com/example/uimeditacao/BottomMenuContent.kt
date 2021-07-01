package com.example.uimeditacao

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.example.uimeditacao.ui.compose.ProfileScreen

data class BottomMenuContent(
    val title: String,
    @DrawableRes val iconId: Int
)
