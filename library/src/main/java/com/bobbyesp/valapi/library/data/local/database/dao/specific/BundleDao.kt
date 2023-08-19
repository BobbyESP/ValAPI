package com.bobbyesp.valapi.library.data.local.database.dao.specific

import androidx.room.Dao
import androidx.room.Query
import com.bobbyesp.valapi.library.data.local.database.dao.BaseDao
import com.bobbyesp.valapi.library.data.local.database.entity.BuddyEntity
import com.bobbyesp.valapi.library.data.local.database.entity.BundleEntity
import java.util.concurrent.TimeUnit

@Dao
interface BundleDao : BaseDao<BundleEntity> {
    /**
     * Get all agents from the database that are not older than 7 days
     *
     * @param outdatedTime the time in milliseconds that is considered outdated
     * @return a list of agents
     */
    @Query("SELECT * FROM bundles WHERE timestamp >= :outdatedTime")
    suspend fun getAll(outdatedTime: Long = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7)): List<BundleEntity>
}