package com.qm.cleanmodule.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.qm.cleanmodule.data.local.entity.CalendarItem
import com.qm.cleanmodule.data.local.dao.CalendarDao


@Database(entities = [CalendarItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun calendarDao() : CalendarDao
}