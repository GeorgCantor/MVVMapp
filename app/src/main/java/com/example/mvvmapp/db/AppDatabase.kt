package com.example.mvvmapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mvvmapp.db.converters.InfoTypeConverter
import com.example.mvvmapp.db.converters.InfoTypeResponseConverter
import com.example.mvvmapp.model.Pokemon
import com.example.mvvmapp.model.PokemonInfo

@Database(entities = [Pokemon::class, PokemonInfo::class], version = 1, exportSchema = false)
@TypeConverters(value = [InfoTypeConverter::class, InfoTypeResponseConverter::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    abstract fun pokemonInfoDao(): PokemonInfoDao
}
