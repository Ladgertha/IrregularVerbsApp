package ru.ladgertha.database_impl.converter

import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import ru.ladgertha.database_api.IrregularVerb
import ru.ladgertha.database_impl.R
import ru.ladgertha.di.lock.CustomReadWriteLock
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class IrregularVerbsFromJsonConverter(
    private val context: Context,
    private val lock: CustomReadWriteLock
) {

    fun getIrregularVerbs(): List<IrregularVerb> {
        val irregularVerbs = mutableListOf<IrregularVerb>()

        val irregularVerbsJSONArray = loadJSONArray(context)
        try {
            irregularVerbsJSONArray?.let {
                for (verb in 0 until irregularVerbsJSONArray.length()) {
                    val irregularVerbObject = irregularVerbsJSONArray.getJSONObject(verb)
                    irregularVerbs.add(
                        IrregularVerb(
                            baseForm = irregularVerbObject.getString("Base form"),
                            pastSimple = irregularVerbObject.getString("Past simple"),
                            pastParticiple = irregularVerbObject.getString("Past participle"),
                            isPopular = irregularVerbObject.getBoolean("Popular"),
                            isDone = false,
                            doneDate = null,
                            lastCheckedDate = null
                        )
                    )
                }
            }
        } catch (e: JSONException) {
        }
        return irregularVerbs
    }

    private fun loadJSONArray(context: Context): JSONArray? {
        val builder = StringBuilder()
        val `in`: InputStream = context.resources.openRawResource(R.raw.verbs_20220313)
        val reader = BufferedReader(InputStreamReader(`in`))
        var line: String?
        try {
            while (reader.readLine().also { line = it } != null) {
                builder.append(line)
            }
            val json = JSONObject(builder.toString())
            return json.getJSONArray("verbs_20220313")
        } catch (exeeption: IOException) {
            exeeption.printStackTrace()
        } catch (exeeption: JSONException) {
            exeeption.printStackTrace()
        }
        return null
    }
}