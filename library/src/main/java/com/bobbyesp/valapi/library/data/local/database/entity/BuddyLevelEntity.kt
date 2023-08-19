package com.bobbyesp.valapi.library.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bobbyesp.valapi.library.domain.model.buddies.levels.BuddyLevel

@Entity(tableName = "buddy_levels")
data class BuddyLevelEntity(
    @PrimaryKey val uuid: String = "",
    val charmLevel: Int = 0,
    val displayName: String = "",
    val displayIcon: String = "",
    val assetPath: String = "",
    val timestamp: Long = System.currentTimeMillis()
) {
    companion object {
        fun BuddyLevelEntity.toBuddyLevel() = BuddyLevel(
            uuid = uuid,
            charmLevel = charmLevel,
            displayName = displayName,
            displayIcon = displayIcon,
            assetPath = assetPath,
        )

        fun BuddyLevel.toEntity() = BuddyLevelEntity(
            uuid = uuid,
            charmLevel = charmLevel,
            displayName = displayName,
            displayIcon = displayIcon,
            assetPath = assetPath,
        )
    }
}
