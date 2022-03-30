package ru.ladgertha.database_api

import java.util.*

data class IrregularVerb(
    val baseForm: String,
    val pastSimple: String,
    val pastParticiple: String,
    val isPopular: Boolean,
    val isDone: Boolean = false,
    val doneDate: Date? = null,
    val lastCheckedDate: Date? = null
)
