package com.qm.cleanmodule.data.local

import com.qm.cleanmodule.data.local.entity.CalendarItem

interface DatabaseHelper {

    suspend fun getCalendarDays(): List<CalendarItem>

    suspend fun insertAll(users: List<CalendarItem>)

}