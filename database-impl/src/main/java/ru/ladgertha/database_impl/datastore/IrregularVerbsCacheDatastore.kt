package ru.ladgertha.database_impl.datastore

import ru.ladgertha.database_api.entity.IrregularVerb
import kotlin.random.Random

class IrregularVerbsCacheDatastore {

    private val irregularVerbsCache = mutableListOf<IrregularVerb>()

    fun getNextVerb(): IrregularVerb? {
        val cacheSize = irregularVerbsCache.size
        if (cacheSize == 0) return null
        val randomNumber = Random.nextInt(cacheSize)
        val irregularVerb = irregularVerbsCache[randomNumber]
        irregularVerbsCache.remove(irregularVerb)
        return irregularVerb
    }

    fun saveVerbsInCache(irregularVerbs: List<IrregularVerb>) {
        irregularVerbsCache.addAll(irregularVerbs)
    }

    fun clearCache() {
        irregularVerbsCache.clear()
    }
}