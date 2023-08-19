package com.bobbyesp.valapi.library.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bobbyesp.valapi.library.domain.model.buddies.Buddy
import com.bobbyesp.valapi.library.domain.model.buddies.levels.BuddyLevel

@Entity(tableName = "buddies")
data class BuddyEntity(
    @PrimaryKey val uuid: String = "",
    val displayName: String = "",
    val isHiddenIfNotOwned: Boolean = false,
    val themeUuid: String? = null,
    val displayIcon: String = "",
    val assetPath: String = "",
    val levels: List<BuddyLevel> = emptyList(),
    val timestamp: Long = System.currentTimeMillis()
) {
    companion object {
        fun BuddyEntity.toBuddy() = Buddy(
            uuid = uuid,
            displayName = displayName,
            isHiddenIfNotOwned = isHiddenIfNotOwned,
            themeUuid = themeUuid,
            displayIcon = displayIcon,
            assetPath = assetPath,
            levels = levels,
        )

        fun Buddy.toEntity() = BuddyEntity(
            uuid = uuid,
            displayName = displayName,
            isHiddenIfNotOwned = isHiddenIfNotOwned,
            themeUuid = themeUuid,
            displayIcon = displayIcon,
            assetPath = assetPath,
            levels = levels,
        )
    }
}
