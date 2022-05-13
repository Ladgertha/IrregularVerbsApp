package ru.ladgertha.database_impl.converter

import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import ru.ladgertha.database_api.entity.IrregularVerbItem
import ru.ladgertha.database_impl.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class IrregularVerbsFromJsonConverter(
    private val context: Context
) {

    fun getIrregularVerbs(): List<IrregularVerbItem> {
        val irregularVerbs = mutableListOf<IrregularVerbItem>()

        val irregularVerbsJSONArray = loadJSONArray(context)
        try {
            irregularVerbsJSONArray?.let {
                for (verb in 0 until irregularVerbsJSONArray.length()) {
                    val irregularVerbObject = irregularVerbsJSONArray.getJSONObject(verb)
                    irregularVerbs.add(
                        IrregularVerbItem(
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
            e.printStackTrace()
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
            return JSONArray(builder.toString())
        } catch (exception: IOException) {
            exception.printStackTrace()
        } catch (exception: JSONException) {
            exception.printStackTrace()
        }
        return null
    }
}