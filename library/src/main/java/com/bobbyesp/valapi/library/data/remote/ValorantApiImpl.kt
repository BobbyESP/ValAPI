package com.bobbyesp.valapi.library.data.remote

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
import com.bobbyesp.valapi.library.domain.model.weapons.Weapon
import com.bobbyesp.valapi.library.domain.model.weapons.WeaponLevel
import com.bobbyesp.valapi.library.domain.model.weapons.Weapons
import com.bobbyesp.valapi.library.domain.model.weapons.skins.WeaponSkin
import com.bobbyesp.valapi.library.domain.model.weapons.skins.WeaponSkins
import com.bobbyesp.valapi.library.domain.model.weapons.skins.chromas.Chroma
import com.bobbyesp.valapi.library.domain.model.weapons.skins.chromas.Chromas
import com.bobbyesp.valapi.library.domain.respository.ValorantAPI
import com.bobbyesp.valapi.library.util.LanguageCode
import com.bobbyesp.valapi.library.util.UrlBuilder.buildUrl
import com.bobbyesp.valapi.library.util.UrlBuilder.buildUuidUrl
import com.bobbyesp.valapi.library.util.network.makeApiCall
import io.ktor.client.HttpClient

class ValorantApiImpl(
    private val client: HttpClient
) : ValorantAPI {
    override suspend fun getAgents(language: LanguageCode, isCharacterPlayable: Boolean): Agents {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["isPlayableCharacter"] = isCharacterPlayable.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Agents.AGENTS),
            params = params
        )

    }

    override suspend fun getAgentByUuid(language: LanguageCode, uuid: String): Agents {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Agents.AGENT, uuid),
            params = params
        )

    }

    override suspend fun getBuddies(language: LanguageCode): Buddies {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Buddies.BUDDIES),
            params = params
        )
    }

    override suspend fun getBuddyLevels(language: LanguageCode): BuddyLevels {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Buddies.LEVELS),
            params = params
        )

    }

    override suspend fun getBuddyByUuid(language: LanguageCode, uuid: String): Buddy {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Buddies.BUDDY, uuid),
            params = params
        )

    }

    override suspend fun getBuddyLevelByUuid(language: LanguageCode, uuid: String): BuddyLevel {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Buddies.LEVEL, uuid),
            params = params
        )

    }

    override suspend fun getBundles(language: LanguageCode): Bundles {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Bundles.BUNDLES),
            params = params
        )

    }

    override suspend fun getBundleByUuid(language: LanguageCode, uuid: String): Bundles {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Bundles.BUNDLE, uuid),
            params = params
        )
    }

    override suspend fun getCeremonies(language: LanguageCode): Ceremonies {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Ceremonies.CEREMONIES),
            params = params
        )
    }

    override suspend fun getCeremonyByUuid(language: LanguageCode, uuid: String): Ceremony {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Ceremonies.CEREMONY, uuid),
            params = params
        )

    }

    override suspend fun getCompetitiveTiers(language: LanguageCode): CompetitiveTiers {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.CompetitiveTiers.COMPETITIVE_TIERS),
            params = params
        )
    }

    override suspend fun getCompetitiveTierByUuid(
        language: LanguageCode,
        uuid: String
    ): CompetitiveTier {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.CompetitiveTiers.COMPETITIVE_TIER, uuid),
            params = params
        )
    }

    override suspend fun getContentTiers(language: LanguageCode): ContentTiers {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.ContentTiers.CONTENT_TIERS),
            params = params
        )
    }

    override suspend fun getContentTierByUuid(language: LanguageCode, uuid: String): ContentTier {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.ContentTiers.CONTENT_TIER, uuid),
            params = params
        )
    }

    override suspend fun getContracts(language: LanguageCode): Contracts {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Contracts.CONTRACTS),
            params = params
        )
    }

    override suspend fun getContractByUuid(language: LanguageCode, uuid: String): Contract {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Contracts.CONTRACT, uuid),
            params = params
        )
    }

    override suspend fun getCurrencies(language: LanguageCode): Currencies {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Currencies.CURRENCIES),
            params = params
        )
    }

    override suspend fun getCurrencyByUuid(language: LanguageCode, uuid: String): Currency {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Currencies.CURRENCY, uuid),
            params = params
        )
    }

    override suspend fun getEvents(language: LanguageCode): Events {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Events.EVENTS),
            params = params
        )
    }

    override suspend fun getEventByUuid(language: LanguageCode, uuid: String): Event {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Events.EVENT, uuid),
            params = params
        )
    }

    override suspend fun getGameModes(language: LanguageCode): Gamemodes {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Gamemodes.GAMEMODES),
            params = params
        )
    }

    override suspend fun getGameModeByUuid(language: LanguageCode, uuid: String): Gamemode {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Gamemodes.GAMEMODE, uuid),
            params = params
        )
    }

    override suspend fun getGameModeEquippables(language: LanguageCode): Equippables {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Gamemodes.EQUIPPABLES),
            params = params
        )

    }

    override suspend fun getGameModeEquippableByUuid(
        language: LanguageCode,
        uuid: String
    ): Equippable {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Gamemodes.EQUIPPABLE, uuid),
            params = params
        )
    }

    override suspend fun getGears(language: LanguageCode): Gears {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Gear.GEARS),
            params = params
        )
    }

    override suspend fun getGearByUuid(language: LanguageCode, uuid: String): Gear {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Gear.GEAR, uuid),
            params = params
        )
    }

    override suspend fun getLevelBorders(language: LanguageCode): LevelBorders {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.LevelBorders.LEVEL_BORDERS),
            params = params
        )
    }

    override suspend fun getLevelBorderByUuid(language: LanguageCode, uuid: String): LevelBorder {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.LevelBorders.LEVEL_BORDER, uuid),
            params = params
        )
    }

    override suspend fun getMaps(language: LanguageCode): Maps {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Maps.MAPS),
            params = params
        )
    }

    override suspend fun getMapByUuid(language: LanguageCode, uuid: String): Map {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Maps.MAP, uuid),
            params = params
        )
    }

    override suspend fun getPlayerCards(language: LanguageCode): PlayerCards {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.PlayerCards.PLAYER_CARDS),
            params = params
        )
    }

    override suspend fun getPlayerCardByUuid(language: LanguageCode, uuid: String): PlayerCard {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.PlayerCards.PLAYER_CARD, uuid),
            params = params
        )
    }

    override suspend fun getPlayerTitles(language: LanguageCode): PlayerTitles {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.PlayerTitles.PLAYER_TITLES),
            params = params
        )
    }

    override suspend fun getPlayerTitleByUuid(language: LanguageCode, uuid: String): PlayerTitle {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.PlayerTitles.PLAYER_TITLE, uuid),
            params = params
        )
    }

    override suspend fun getSeasons(language: LanguageCode): Seasons {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Seasons.SEASONS),
            params = params
        )
    }

    override suspend fun getSeasonByUuid(language: LanguageCode, uuid: String): Season {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Seasons.SEASON, uuid),
            params = params
        )
    }

    override suspend fun getCompetitiveSeasons(): CompetitiveSeasons {
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Seasons.SEASONS_COMPETITIVE),
            params = mutableMapOf()
        )

    }

    override suspend fun getCompetitiveSeasonByUuid(
        uuid: String
    ): CompetitiveSeason {
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Seasons.SEASON_COMPETITIVE, uuid),
            params = mutableMapOf()
        )

    }

    override suspend fun getSprays(language: LanguageCode): Sprays {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Sprays.SPRAYS),
            params = params
        )
    }

    override suspend fun getSprayByUuid(language: LanguageCode, uuid: String): Spray {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Sprays.SPRAY, uuid),
            params = params
        )

    }

    override suspend fun getSprayLevels(language: LanguageCode): SprayLevels {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Sprays.LEVELS),
            params = params
        )
    }

    override suspend fun getSprayLevelByUuid(language: LanguageCode, uuid: String): SprayLevel {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Sprays.LEVEL, uuid),
            params = params
        )
    }

    override suspend fun getThemes(language: LanguageCode): Themes {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Themes.THEMES),
            params = params
        )
    }

    override suspend fun getThemeByUuid(language: LanguageCode, uuid: String): Theme {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Themes.THEME, uuid),
            params = params
        )
    }

    override suspend fun getWeapons(language: LanguageCode): Weapons {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Weapons.WEAPONS),
            params = params
        )

    }

    override suspend fun getWeaponByUuid(language: LanguageCode, uuid: String): Weapon {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Weapons.WEAPON, uuid),
            params = params
        )
    }

    override suspend fun getWeaponSkins(language: LanguageCode): WeaponSkins {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Weapons.SKINS),
            params = params
        )
    }

    override suspend fun getWeaponSkinByUuid(language: LanguageCode, uuid: String): WeaponSkin {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Weapons.SKIN, uuid),
            params = params
        )
    }

    override suspend fun getWeaponSkinChromas(language: LanguageCode): Chromas {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Weapons.CHROMAS),
            params = params
        )
    }

    override suspend fun getWeaponSkinChromaByUuid(language: LanguageCode, uuid: String): Chroma {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Weapons.CHROMA, uuid),
            params = params
        )
    }

    override suspend fun getWeaponSkinLevels(language: LanguageCode): List<WeaponLevel> {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Weapons.LEVELS),
            params = params
        )
    }

    override suspend fun getWeaponSkinLevelByUuid(
        language: LanguageCode,
        uuid: String
    ): WeaponLevel {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Weapons.LEVEL, uuid),
            params = params
        )
    }

    override suspend fun getVersion(): Version {
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Version.VERSION),
            params = mutableMapOf()
        )
    }
}