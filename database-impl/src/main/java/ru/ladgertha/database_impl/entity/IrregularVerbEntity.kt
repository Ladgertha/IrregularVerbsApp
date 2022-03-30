package ru.ladgertha.database_impl.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.ladgertha.database_impl.contract.IrregularVerbContract.DAO.Companion.KEY_BASE_FORM
import ru.ladgertha.database_impl.contract.IrregularVerbContract.DAO.Companion.KEY_DONE_DATE
import ru.ladgertha.database_impl.contract.IrregularVerbContract.DAO.Companion.KEY_IS_DONE
import ru.ladgertha.database_impl.contract.IrregularVerbContract.DAO.Companion.KEY_IS_POPULAR
import ru.ladgertha.database_impl.contract.IrregularVerbContract.DAO.Companion.KEY_LAST_CHECKED_DATE
import ru.ladgertha.database_impl.contract.IrregularVerbContract.DAO.Companion.KEY_PAST_PARTICIPLE
import ru.ladgertha.database_impl.contract.IrregularVerbContract.DAO.Companion.KEY_PAST_SIMPLE
import ru.ladgertha.database_impl.contract.IrregularVerbContract.DAO.Companion.TABLE_NAME_IRREGULAR_VERBS
import ru.ladgertha.database_impl.converter.DateConverter
import java.util.*

@Entity(tableName = TABLE_NAME_IRREGULAR_VERBS)
data class IrregularVerbEntity(

    @PrimaryKey
    @ColumnInfo(name = KEY_BASE_FORM, index = true)
    val baseForm: String,

    @ColumnInfo(name = KEY_PAST_SIMPLE)
    val pastSimple: String,

    @ColumnInfo(name = KEY_PAST_PARTICIPLE)
    val pastParticiple: String,

    @ColumnInfo(name = KEY_IS_POPULAR)
    val isPopular: Boolean,

    @ColumnInfo(name = KEY_IS_DONE)
    val isDone: Boolean,

    @ColumnInfo(name = KEY_DONE_DATE)
    @field:TypeConverters(DateConverter::class)
    val doneDate: Date?,

    @ColumnInfo(name = KEY_LAST_CHECKED_DATE)
    @field:TypeConverters(DateConverter::class)
    val lastCheckedDate: Date?

    // TODO Подумать, что еще нужно
)