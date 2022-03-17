package ru.ladgertha.database_impl

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.ladgertha.database_impl.IrregularVerbContract.DAO.Companion.KEY_IRREGULAR_VERB_KEY
import ru.ladgertha.database_impl.IrregularVerbContract.DAO.Companion.TABLE_NAME_IRREGULAR_VERBS

@Entity(tableName = TABLE_NAME_IRREGULAR_VERBS)
data class IrregularVerbEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = KEY_IRREGULAR_VERB_KEY)
    val id: Long
)