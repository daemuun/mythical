package com.example.mythical.data

import com.example.mythical.R
import com.example.mythical.model.Character

object Datasource {
    fun getCharactersList(): List<Character> {
        return listOf<Character>(
            Character(R.string.name1, R.string.description1, R.drawable.myth1),
            Character(R.string.name2, R.string.description2, R.drawable.myth2),
            Character(R.string.name3, R.string.description3, R.drawable.myth3),
            Character(R.string.name4, R.string.description4, R.drawable.myth4),
            Character(R.string.name5, R.string.description5, R.drawable.myth5),
            Character(R.string.name6, R.string.description6, R.drawable.myth6),
            Character(R.string.name7, R.string.description7, R.drawable.myth7),
            Character(R.string.name8, R.string.description8, R.drawable.myth8),
            Character(R.string.name9, R.string.description9, R.drawable.myth9),
            Character(R.string.name10, R.string.description10, R.drawable.myth10),
        )
    }
}