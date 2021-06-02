package com.qm.cleanmodule.data.local

import com.qm.cleanmodule.data.local.AppDatabase
import com.qm.cleanmodule.data.local.DatabaseHelper
import com.qm.cleanmodule.data.local.entity.CalendarItem

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {
    override suspend fun getCalendarDays() = appDatabase.calendarDao().getAll()

    override suspend fun insertAll(list: List<CalendarItem>) =
        appDatabase.calendarDao().insertAll(list)
}