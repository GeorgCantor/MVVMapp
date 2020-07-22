package com.example.mvvmapp.db.converters

import androidx.room.TypeConverter
import com.example.mvvmapp.model.PokemonInfo
import com.squareup.moshi.Moshi

open class InfoTypeConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): PokemonInfo.Type? =
        moshi.adapter(PokemonInfo.Type::class.java).fromJson(value)

    @TypeConverter
    fun fromInfoType(type: PokemonInfo.Type): String =
        moshi.adapter(PokemonInfo.Type::class.java).toJson(type)
}
