package com.bobbyesp.valapi.library.data.local.database.dao.specific

import androidx.room.Dao
import androidx.room.Query
import com.bobbyesp.valapi.library.data.local.database.dao.BaseDao
import com.bobbyesp.valapi.library.data.local.database.entity.BuddyEntity
import com.bobbyesp.valapi.library.data.local.database.entity.BuddyLevelEntity
import com.bobbyesp.valapi.library.util.TimeUtil.ONE_WEEK_OLD
import java.util.concurrent.TimeUnit

@Dao
interface BuddyDao : BaseDao<BuddyEntity> {
    /**
     * Get all agents from the database that are not older than 7 days
     *
     * @param outdatedTime the time in milliseconds that is considered outdated
     * @return a list of agents
     */
    @Query("SELECT * FROM buddies WHERE timestamp >= :outdatedTime")
    suspend fun getAll(outdatedTime: Long = ONE_WEEK_OLD): List<BuddyEntity>


    @Query("SELECT * FROM buddy_levels WHERE timestamp >= :outdatedTime")
    suspend fun getAllBuddyLevels(outdatedTime: Long = ONE_WEEK_OLD): List<BuddyLevelEntity>

    //insert buddy level
    @Query("INSERT INTO buddy_levels VALUES (:uuid, :charmLevel, :displayName, :displayIcon, :assetPath, :timestamp)")
    suspend fun insertBuddyLevel(
        uuid: String,
        charmLevel: Int,
        displayName: String,
        displayIcon: String,
        assetPath: String,
        timestamp: Long = System.currentTimeMillis()
    )

    //get buddy by uuid
    @Query("SELECT * FROM buddies WHERE uuid = :uuid AND timestamp >= :outdatedTime")
    suspend fun getBuddyByUuid(uuid: String, outdatedTime: Long = ONE_WEEK_OLD ): BuddyEntity?

    //get buddy level by uuid
    @Query("SELECT * FROM buddy_levels WHERE uuid = :uuid AND timestamp >= :outdatedTime")
    suspend fun getBuddyLevelByUuid(uuid: String, outdatedTime: Long = ONE_WEEK_OLD ): BuddyLevelEntity?
}