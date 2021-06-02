package com.qm.cleanmodule.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.qm.cleanmodule.data.local.entity.CalendarItem


@Dao
interface CalendarDao {
    @Query("SELECT * FROM calendaritem")
    suspend fun getAll(): List<CalendarItem>

    @Insert
    suspend fun insertAll(calendarItems: List<CalendarItem>)
}