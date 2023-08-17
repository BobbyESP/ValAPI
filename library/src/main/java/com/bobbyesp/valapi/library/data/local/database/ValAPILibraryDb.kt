package com.bobbyesp.valapi.library.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bobbyesp.valapi.library.data.local.database.dao.AgentDao
import com.bobbyesp.valapi.library.data.local.database.dao.BuddyDao
import com.bobbyesp.valapi.library.data.local.database.dao.BundleDao
import com.bobbyesp.valapi.library.data.local.database.entity.AgentEntity
import com.bobbyesp.valapi.library.data.local.database.entity.BuddyEntity
import com.bobbyesp.valapi.library.data.local.database.entity.BuddyLevelEntity
import com.bobbyesp.valapi.library.data.local.database.entity.BundleEntity
import com.bobbyesp.valapi.library.data.local.database.entity.CeremonyEntity
import com.bobbyesp.valapi.library.data.local.database.entity.ChromaEntity
import com.bobbyesp.valapi.library.data.local.database.entity.CompetitiveSeasonEntity
import com.bobbyesp.valapi.library.data.local.database.entity.CompetitiveTierEntity
import com.bobbyesp.valapi.library.data.local.database.entity.ContentTierEntity
import com.bobbyesp.valapi.library.data.local.database.entity.ContentTypeConverters
import com.bobbyesp.valapi.library.data.local.database.entity.ContractEntity
import com.bobbyesp.valapi.library.data.local.database.entity.CurrencyEntity
import com.bobbyesp.valapi.library.data.local.database.entity.EquippableEntity
import com.bobbyesp.valapi.library.data.local.database.entity.EventEntity
import com.bobbyesp.valapi.library.data.local.database.entity.GamemodeEntity
import com.bobbyesp.valapi.library.data.local.database.entity.GearEntity
import com.bobbyesp.valapi.library.data.local.database.entity.LevelBorderEntity
import com.bobbyesp.valapi.library.data.local.database.entity.MapEntity
import com.bobbyesp.valapi.library.data.local.database.entity.PlayerCardEntity
import com.bobbyesp.valapi.library.data.local.database.entity.PlayerTitleEntity
import com.bobbyesp.valapi.library.data.local.database.entity.SeasonEntity
import com.bobbyesp.valapi.library.data.local.database.entity.SkinLevelEntity
import com.bobbyesp.valapi.library.data.local.database.entity.SprayEntity
import com.bobbyesp.valapi.library.data.local.database.entity.SprayLevelEntity
import com.bobbyesp.valapi.library.data.local.database.entity.SprayLevelEntityTypeConverters
import com.bobbyesp.valapi.library.data.local.database.entity.ThemeEntity
import com.bobbyesp.valapi.library.data.local.database.entity.VersionEntity
import com.bobbyesp.valapi.library.data.local.database.entity.WeaponEntity
import com.bobbyesp.valapi.library.data.local.database.entity.WeaponSkinEntity
import com.bobbyesp.valapi.library.domain.model.agent.AbilityTypeConverter
import com.bobbyesp.valapi.library.domain.model.agent.RoleTypeConverters
import com.bobbyesp.valapi.library.domain.model.agent.VoiceLineTypeConverter
import com.bobbyesp.valapi.library.domain.model.buddies.levels.BuddyLevelTypeConverters
import com.bobbyesp.valapi.library.domain.model.gamemodes.GameFeatureOverrideTypeConverters
import com.bobbyesp.valapi.library.domain.model.gamemodes.GameRuleBoolOverrideTypeConverters
import com.bobbyesp.valapi.library.domain.model.gear.GearTypeConverters
import com.bobbyesp.valapi.library.domain.model.gear.ShopDataTypeConverters
import com.bobbyesp.valapi.library.domain.model.maps.CalloutTypeConverters
import com.bobbyesp.valapi.library.domain.model.seasons.competitive.BorderTypeConverters
import com.bobbyesp.valapi.library.domain.model.weapons.SkinLevelTypeConverters
import com.bobbyesp.valapi.library.domain.model.weapons.WeaponStatsTypeConverters
import com.bobbyesp.valapi.library.domain.model.weapons.skins.WeaponSkinTypeConverters
import com.bobbyesp.valapi.library.domain.model.weapons.skins.chromas.ChromaTypeConverters

@Database(
    entities = [
        AgentEntity::class,
        BuddyEntity::class,
        BuddyLevelEntity::class,
        BundleEntity::class,
        CeremonyEntity::class,
        CompetitiveTierEntity::class,
        ContentTierEntity::class,
        ContractEntity::class,
        CurrencyEntity::class,
        EquippableEntity::class,
        EventEntity::class,
        GamemodeEntity::class,
        GearEntity::class,
        LevelBorderEntity::class,
        MapEntity::class,
        PlayerCardEntity::class,
        PlayerTitleEntity::class,
        SeasonEntity::class,
        CompetitiveSeasonEntity::class,
        SprayEntity::class,
        SprayLevelEntity::class,
        ThemeEntity::class,
        VersionEntity::class,
        WeaponEntity::class,
        WeaponSkinEntity::class,
        ChromaEntity::class,
        SkinLevelEntity::class
    ],
    version = 1
)
@TypeConverters(
    DbTypeConverters::class,
    AbilityTypeConverter::class,
    RoleTypeConverters::class,
    VoiceLineTypeConverter::class,
    BuddyLevelTypeConverters::class,
    ContentTypeConverters::class,
    GameFeatureOverrideTypeConverters::class,
    GearTypeConverters::class,
    GameRuleBoolOverrideTypeConverters::class,
    ShopDataTypeConverters::class,
    WeaponSkinTypeConverters::class,
    WeaponStatsTypeConverters::class,
    SprayLevelEntityTypeConverters::class,
    ChromaTypeConverters::class,
    CalloutTypeConverters::class,
    BorderTypeConverters::class,
    SkinLevelTypeConverters::class
)
abstract class ValAPILibraryDb : RoomDatabase() {
    abstract fun agentDao(): AgentDao
    abstract fun buddyDao(): BuddyDao
    abstract fun bundleDao(): BundleDao

    companion object {
        const val DATABASE_NAME = "valapi_library_db"
    }
}