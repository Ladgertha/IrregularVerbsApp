package ru.ladgertha.database_impl.contract

import ru.ladgertha.database_impl.dao.BaseDao
import ru.ladgertha.database_impl.entity.IrregularVerbEntity

interface IrregularVerbContract {

    interface DAO : BaseDao<IrregularVerbEntity> {
        fun getIrregularVerbs(): List<IrregularVerbEntity>?

        fun getFirstIrregularVerb(): IrregularVerbEntity?

        fun getIrregularVerb(rareVerb: Boolean, lastCheckedTime: Long): IrregularVerbEntity?

        fun getIrregularVerbs(rareVerb: Boolean, lastCheckedTime: Long): List<IrregularVerbEntity>?

        fun getIrregularVerb(rareVerb: Boolean): IrregularVerbEntity?

        fun getIrregularVerbs(rareVerb: Boolean): List<IrregularVerbEntity>?

        fun updateLastCheckedDateByBaseForm(baseForm: String, lastCheckedTime: Long)

        fun getIrregularVerbsCount(): Int

        companion object {
            const val TABLE_NAME_IRREGULAR_VERBS = "IRREGULAR_VERBS"
            const val KEY_IRREGULAR_VERB_KEY = "IRREGULAR_VERB_KEY"
            const val KEY_BASE_FORM = "BASE_FORM"
            const val KEY_PAST_SIMPLE = "PAST_SIMPLE"
            const val KEY_PAST_PARTICIPLE = "PAST_PARTICIPLE"
            const val KEY_IS_POPULAR = "IS_POPULAR"
            const val KEY_IS_DONE = "IS_DONE"
            const val KEY_DONE_DATE = "DONE_DATE"
            const val KEY_LAST_CHECKED_DATE = "LAST_CHECKED_DATE"
        }
    }
}