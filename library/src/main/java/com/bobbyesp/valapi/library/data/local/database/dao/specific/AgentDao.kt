package com.bobbyesp.valapi.library.data.local.database.dao.specific

import androidx.room.Dao
import androidx.room.Query
import com.bobbyesp.valapi.library.data.local.database.dao.BaseDao
import com.bobbyesp.valapi.library.data.local.database.entity.AgentEntity

@Dao
interface AgentDao : BaseDao<AgentEntity> {
    @Query("SELECT * FROM agents")
    suspend fun getAll(): List<AgentEntity>
}