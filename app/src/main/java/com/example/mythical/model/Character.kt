package com.example.mythical.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Character(
    @StringRes val nameId: Int,
    @StringRes val descriptionId: Int,
    @DrawableRes val imageId: Int
)
