package ru.ladgertha.database_impl.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.ladgertha.database_impl.contract.IrregularVerbContract
import ru.ladgertha.database_impl.entity.IrregularVerbEntity

const val VERSION = 1

@Database(
    entities = [
        IrregularVerbEntity::class
    ],
    exportSchema = true,
    version = VERSION
)
abstract class StorageDatabase : RoomDatabase(), IStorageDatabase {

    abstract override fun irregularVerbDao(): IrregularVerbContract.DAO

    companion object {
        private const val DATABASE_NAME = "irregular_verbs"

        @Volatile
        private var INSTANCE: StorageDatabase? = null

        fun getInstance(context: Context): StorageDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: create(context).also { INSTANCE = it }
            }

        private fun create(context: Context): StorageDatabase {
            return Room.databaseBuilder(
                context,
                StorageDatabase::class.java,
                DATABASE_NAME
            )
                .build()
        }
    }
}
