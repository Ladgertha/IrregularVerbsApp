package ru.ladgertha.database_impl.converter

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Test
import java.util.*

class DateConverterTest {
    private val date = Date()
    private val dateLong = date.time

    @Test
    fun `date converter returns date from valid long`() {
        val result = DateConverter.toDate(dateLong)
        assertEquals(date, result)
    }

    @Test
    fun `date converter returns null when date long is null`() {
        val result = DateConverter.toDate(null)
        assertNull(result)
    }

    @Test
    fun `date converter returns valid long from date`() {
        val result = DateConverter.fromDate(date)
        assertEquals(dateLong, result)
    }

    @Test
    fun `date converter returns null when date is null`() {
        val result = DateConverter.fromDate(null)
        assertNull(result)
    }
}