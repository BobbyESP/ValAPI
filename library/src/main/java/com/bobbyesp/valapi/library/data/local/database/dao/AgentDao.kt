package com.bobbyesp.valapi.library.data.local.database.dao

import androidx.room.Dao
import com.bobbyesp.valapi.library.data.local.database.entity.AgentEntity

@Dao
interface AgentDao: BaseDao<AgentEntity> {

//    @Query("SELECT * FROM AgentEntity")
//    suspend fun getAll(): List<AgentEntity>
}