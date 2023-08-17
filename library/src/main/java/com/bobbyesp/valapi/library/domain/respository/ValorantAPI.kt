package com.bobbyesp.valapi.library.domain.respository

import com.bobbyesp.valapi.library.data.remote.ValorantApiImpl
import com.bobbyesp.valapi.library.domain.model.agent.Agents
import com.bobbyesp.valapi.library.domain.model.buddies.Buddies
import com.bobbyesp.valapi.library.domain.model.buddies.Buddy
import com.bobbyesp.valapi.library.domain.model.buddies.levels.BuddyLevel
import com.bobbyesp.valapi.library.domain.model.buddies.levels.BuddyLevels
import com.bobbyesp.valapi.library.domain.model.bundles.Bundles
import com.bobbyesp.valapi.library.domain.model.ceremonies.Ceremonies
import com.bobbyesp.valapi.library.domain.model.ceremonies.Ceremony
import com.bobbyesp.valapi.library.domain.model.competitive_tiers.CompetitiveTier
import com.bobbyesp.valapi.library.domain.model.competitive_tiers.CompetitiveTiers
import com.bobbyesp.valapi.library.domain.model.content_tiers.ContentTier
import com.bobbyesp.valapi.library.domain.model.content_tiers.ContentTiers
import com.bobbyesp.valapi.library.domain.model.contracts.Contract
import com.bobbyesp.valapi.library.domain.model.contracts.Contracts
import com.bobbyesp.valapi.library.domain.model.currencies.Currencies
import com.bobbyesp.valapi.library.domain.model.currencies.Currency
import com.bobbyesp.valapi.library.domain.model.events.Event
import com.bobbyesp.valapi.library.domain.model.events.Events
import com.bobbyesp.valapi.library.domain.model.gamemodes.Gamemode
import com.bobbyesp.valapi.library.domain.model.gamemodes.Gamemodes
import com.bobbyesp.valapi.library.domain.model.gamemodes.equippables.Equippable
import com.bobbyesp.valapi.library.domain.model.gamemodes.equippables.Equippables
import com.bobbyesp.valapi.library.domain.model.gear.Gear
import com.bobbyesp.valapi.library.domain.model.gear.Gears
import com.bobbyesp.valapi.library.domain.model.level_borders.LevelBorder
import com.bobbyesp.valapi.library.domain.model.level_borders.LevelBorders
import com.bobbyesp.valapi.library.domain.model.maps.Map
import com.bobbyesp.valapi.library.domain.model.maps.Maps
import com.bobbyesp.valapi.library.domain.model.player_cards.PlayerCard
import com.bobbyesp.valapi.library.domain.model.player_cards.PlayerCards
import com.bobbyesp.valapi.library.domain.model.player_titles.PlayerTitle
import com.bobbyesp.valapi.library.domain.model.player_titles.PlayerTitles
import com.bobbyesp.valapi.library.domain.model.seasons.Season
import com.bobbyesp.valapi.library.domain.model.seasons.Seasons
import com.bobbyesp.valapi.library.domain.model.seasons.competitive.CompetitiveSeason
import com.bobbyesp.valapi.library.domain.model.seasons.competitive.CompetitiveSeasons
import com.bobbyesp.valapi.library.domain.model.sprays.Spray
import com.bobbyesp.valapi.library.domain.model.sprays.SprayLevel
import com.bobbyesp.valapi.library.domain.model.sprays.Sprays
import com.bobbyesp.valapi.library.domain.model.sprays.levels.SprayLevels
import com.bobbyesp.valapi.library.domain.model.themes.Theme
import com.bobbyesp.valapi.library.domain.model.themes.Themes
import com.bobbyesp.valapi.library.domain.model.version.Version
import com.bobbyesp.valapi.library.domain.model.weapons.SkinLevel
import com.bobbyesp.valapi.library.domain.model.weapons.Weapon
import com.bobbyesp.valapi.library.domain.model.weapons.Weapons
import com.bobbyesp.valapi.library.domain.model.weapons.skins.WeaponSkin
import com.bobbyesp.valapi.library.domain.model.weapons.skins.WeaponSkins
import com.bobbyesp.valapi.library.domain.model.weapons.skins.chromas.Chroma
import com.bobbyesp.valapi.library.domain.model.weapons.skins.chromas.Chromas
import com.bobbyesp.valapi.library.util.LanguageCode
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface ValorantAPI {
    // --------------- AGENTS ---------------
    suspend fun getAgents(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        isCharacterPlayable: Boolean = true
    ): Agents

    suspend fun getAgentByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Agents

    // --------------- BUDDIES ---------------
    suspend fun getBuddies(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Buddies

    suspend fun getBuddyLevels(
        language: LanguageCode = LanguageCode.ENGLISH_US,
    ): BuddyLevels

    suspend fun getBuddyByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Buddy

    suspend fun getBuddyLevelByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): BuddyLevel

    // --------------- BUNDLES ---------------

    suspend fun getBundles(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Bundles

    suspend fun getBundleByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Bundles

    // --------------- CEREMONIES ---------------
    suspend fun getCeremonies(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Ceremonies

    suspend fun getCeremonyByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Ceremony

    // -------------- COMPETITIVE TIERS --------------

    suspend fun getCompetitiveTiers(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): CompetitiveTiers

    suspend fun getCompetitiveTierByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): CompetitiveTier

    // -------------- CONTENT TIERS --------------
    suspend fun getContentTiers(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): ContentTiers

    suspend fun getContentTierByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): ContentTier

    // -------------- CONTRACTS --------------
    suspend fun getContracts(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Contracts

    suspend fun getContractByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Contract

    // -------------- CURRENCIES --------------
    suspend fun getCurrencies(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Currencies

    suspend fun getCurrencyByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Currency

    // -------------- EVENTS -----------------
    suspend fun getEvents(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Events

    suspend fun getEventByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Event

    // -------------- GAME MODES --------------
    suspend fun getGameModes(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Gamemodes

    suspend fun getGameModeByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Gamemode

    suspend fun getGameModeEquippables(
        language: LanguageCode = LanguageCode.ENGLISH_US,
    ): Equippables

    suspend fun getGameModeEquippableByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Equippable

    // -------------- GEAR --------------
    suspend fun getGears(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Gears

    suspend fun getGearByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Gear

    // -------------- LEVEL BORDERS --------------
    suspend fun getLevelBorders(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): LevelBorders

    suspend fun getLevelBorderByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): LevelBorder

    // -------------- MAPS --------------
    suspend fun getMaps(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Maps

    suspend fun getMapByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Map

    // -------------- PLAYER CARDS --------------
    suspend fun getPlayerCards(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): PlayerCards

    suspend fun getPlayerCardByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): PlayerCard

    // -------------- PLAYER TITLES --------------
    suspend fun getPlayerTitles(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): PlayerTitles

    suspend fun getPlayerTitleByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): PlayerTitle

    // -------------- SEASONS --------------
    suspend fun getSeasons(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Seasons

    suspend fun getSeasonByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Season

    suspend fun getCompetitiveSeasons(
    ): CompetitiveSeasons

    suspend fun getCompetitiveSeasonByUuid(
        uuid: String
    ): CompetitiveSeason

    // -------------- SPRAYS --------------
    suspend fun getSprays(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Sprays

    suspend fun getSprayByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Spray

    suspend fun getSprayLevels(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): SprayLevels

    suspend fun getSprayLevelByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): SprayLevel

    // -------------- THEMES --------------
    suspend fun getThemes(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Themes

    suspend fun getThemeByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Theme

    // -------------- WEAPONS -------------
    suspend fun getWeapons(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Weapons

    suspend fun getWeaponByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Weapon

    suspend fun getWeaponSkins(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): WeaponSkins

    suspend fun getWeaponSkinByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): WeaponSkin

    suspend fun getWeaponSkinChromas(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): Chromas

    suspend fun getWeaponSkinChromaByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): Chroma

    suspend fun getWeaponSkinLevels(
        language: LanguageCode = LanguageCode.ENGLISH_US
    ): List<SkinLevel>

    suspend fun getWeaponSkinLevelByUuid(
        language: LanguageCode = LanguageCode.ENGLISH_US,
        uuid: String
    ): SkinLevel

    // -------------- VERSION -------------
    suspend fun getVersion(): Version

    companion object {
        fun create(engine: HttpClientEngineFactory<*> = Android): ValorantAPI = ValorantApiImpl(
            HttpClient(engine) {
                install(Logging) { // Install default logger for Ktor
                    level = LogLevel.ALL
                }
                install(ContentNegotiation) { // Install JSON serializer using Kotlinx serialization
                    json(
                        contentType = ContentType.Application.Json,
                        json = Json {
                            ignoreUnknownKeys = true
                            encodeDefaults = true
                        }
                    )
                }
                install(HttpCache) // Install default cache (in-memory)
            }
        )
    }
}