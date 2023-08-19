package com.bobbyesp.valapi.library.data.local.database.dao.specific

import androidx.room.Dao
import androidx.room.Query
import com.bobbyesp.valapi.library.data.local.database.dao.BaseDao
import com.bobbyesp.valapi.library.data.local.database.entity.AgentEntity
import com.bobbyesp.valapi.library.util.LanguageCode
import com.bobbyesp.valapi.library.util.TimeUtil.ONE_WEEK_OLD
import java.util.concurrent.TimeUnit

@Dao
interface AgentDao : BaseDao<AgentEntity> {

    /**
     * Get all agents from the database that are not older than 7 days
     *
     * @param outdatedTime the time in milliseconds that is considered outdated
     * @return a list of agents
     */
    @Query("SELECT * FROM agents WHERE timestamp >= :outdatedTime AND language = :languageCode")
    suspend fun getAll(outdatedTime: Long = ONE_WEEK_OLD, languageCode: LanguageCode = LanguageCode.ENGLISH_US): List<AgentEntity>

    /**
     * Get an agent from the database by its uuid
     *
     * @param uuid the uuid of the agent
     * @return the agent
     */
    @Query("SELECT * FROM agents WHERE uuid = :uuid AND language = :languageCode AND timestamp >= :outdatedTime")
    suspend fun getAgent(uuid: String, outdatedTime: Long = ONE_WEEK_OLD, languageCode: LanguageCode = LanguageCode.ENGLISH_US): AgentEntity?
}