package com.skedulo.automation.api

import com.skedulo.automation.api.utils.TestParent
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format.ISODateTimeFormat
import org.junit.Test

class MobileApiTest: TestParent() {


    @Test
    fun testGetMobileInitial() {
        val call = apiClient.mobileApi.getInitialUserData()
        val response = call.execute()
        println("response code = ${response.code()}")
        if (response.isSuccessful) {
            val data = response.body()
            println(data)
        }
    }
    @Test
    fun getMobileAgenda() {
        val start = getStartOfTodayIsoDate()
        val end = getEndOfTodayIsoDate()
        val call = apiClient.mobileApi.getAgenda(start, end)
        val response = call.execute()
        println("response code = ${response.code()}")
        if (response.isSuccessful) {
            val data = response.body()
            println(data)
        }
    }
    private fun getEndOfTodayIsoDate(): String {
        //TimeZone timeZone = TimeZone.getTimeZone("Australia/Brisbane");
        val dt = DateTime(DateTimeZone.UTC).plusHours(10).withTime(23, 59, 59, 999)
        val fmt = ISODateTimeFormat.dateTime()
        return fmt.print(dt)
    }
    private fun getStartOfTodayIsoDate(): String {
        //TimeZone timeZone = TimeZone.getTimeZone("Australia/Brisbane");
        val dt = DateTime(DateTimeZone.UTC).plusHours(10).withTime(0, 0, 0, 999)
        val fmt = ISODateTimeFormat.dateTime()
        return fmt.print(dt)
    }
    private fun getIsoDate(hour: Int, minute: Int): String {
        //TimeZone timeZone = TimeZone.getTimeZone("Australia/Brisbane");
        val dt = DateTime(DateTimeZone.UTC).withTime(hour, minute, 59, 999)
        val fmt = ISODateTimeFormat.dateTime()
        return fmt.print(dt)
    }
}
