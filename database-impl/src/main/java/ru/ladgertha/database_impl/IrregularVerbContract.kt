package ru.ladgertha.database_impl


interface IrregularVerbContract {

    interface DAO : BaseDao<IrregularVerbEntity> {
        fun getIrregularVerbs(): List<IrregularVerbEntity>?

        companion object {
            const val TABLE_NAME_IRREGULAR_VERBS = "IRREGULAR_VERBS"
            const val KEY_IRREGULAR_VERB_KEY = "IRREGULAR_VERB_KEY"
        }
    }
}