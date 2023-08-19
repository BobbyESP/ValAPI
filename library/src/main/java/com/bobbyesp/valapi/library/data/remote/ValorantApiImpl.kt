package com.bobbyesp.valapi.library.data.remote

import com.bobbyesp.valapi.library.domain.model.agent.Agent
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
import com.bobbyesp.valapi.library.domain.respository.ValorantAPI
import com.bobbyesp.valapi.library.util.LanguageCode
import com.bobbyesp.valapi.library.util.UrlBuilder.buildUrl
import com.bobbyesp.valapi.library.util.UrlBuilder.buildUuidUrl
import com.bobbyesp.valapi.library.util.network.makeApiCall
import io.ktor.client.HttpClient

class ValorantApiImpl(
    private val client: HttpClient
) : ValorantAPI {
    /**
     * Get all the agents of the game.
     * Correspondence to the API route: [/agents](https://valorant-api.com/v1/agents)
     *
     * @param language The language of the response. Default is English
     * @param isCharacterPlayable Whether the agent is playable or not. Default is true
     *
     * @return [Agents] object that contains a list with the agents and the HTTP status code
     */
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

    /**
     * Get an agent by its UUID.
     * Correspondence to the API route: [/agents/:uuid](https://valorant-api.com/v1/agents/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the agent
     *
     * @return [Agents] object that contains a list with the agents and the HTTP status code
     */
    override suspend fun getAgentByUuid(language: LanguageCode, uuid: String): Agent {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        params["uuid"] = uuid

        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Agents.AGENT, uuid),
            params = params
        )

    }

    /**
     * Get the buddies of the game.
     * Correspondence to the API route: [/buddies](https://valorant-api.com/v1/buddies/levels)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Buddies] object that contains a list with the buddy levels and the HTTP status code
     */
    override suspend fun getBuddies(language: LanguageCode): Buddies {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Buddies.BUDDIES),
            params = params
        )
    }

    /**
     * Get the buddy levels of the game.
     * Correspondence to the API route: [/buddies/levels](https://valorant-api.com/v1/buddies/levels)
     *
     * @param language The language of the response. Default is English
     *
     * @return [BuddyLevels] object that contains a list with the buddy levels and the HTTP status code
     */
    override suspend fun getBuddyLevels(language: LanguageCode): BuddyLevels {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Buddies.LEVELS),
            params = params
        )

    }

    /**
     * Get a buddy by its UUID.
     * Correspondence to the API route: [/buddies/:uuid](https://valorant-api.com/v1/buddies/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the buddy
     *
     * @return [Buddy] object that contains the buddy
     */
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

    /**
     * Get a buddy level by its UUID.
     * Correspondence to the API route: [/buddies/levels/:uuid](https://valorant-api.com/v1/buddies/levels/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the buddy level
     *
     * @return [BuddyLevel] object that contains the buddy level
     */
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

    /**
     * Get the bundles of the game.
     * Correspondence to the API route: [/bundles](https://valorant-api.com/v1/bundles)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Bundles] object that contains a list with the bundles and the HTTP status code
     */
    override suspend fun getBundles(language: LanguageCode): Bundles {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Bundles.BUNDLES),
            params = params
        )

    }

    /**
     * Get a bundle by its UUID.
     * Correspondence to the API route: [/bundles/:uuid](https://valorant-api.com/v1/bundles/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the bundle
     *
     * @return [Bundles] object that contains a list with the bundles and the HTTP status code
     */
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

    /**
     * Get the ceremonies of the game.
     * Correspondence to the API route: [/ceremonies](https://valorant-api.com/v1/ceremonies)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Ceremonies] object that contains a list with the ceremonies and the HTTP status code
     */
    override suspend fun getCeremonies(language: LanguageCode): Ceremonies {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Ceremonies.CEREMONIES),
            params = params
        )
    }

    /**
     * Get a ceremony by its UUID.
     * Correspondence to the API route: [/ceremonies/:uuid](https://valorant-api.com/v1/ceremonies/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the ceremony
     *
     * @return [Ceremony] object that contains the ceremony
     */
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

    /**
     * Get the competitive tiers of the game.
     * Correspondence to the API route: [/competitive-tiers](https://valorant-api.com/v1/competitive-tiers)
     *
     * @param language The language of the response. Default is English
     *
     * @return [CompetitiveTiers] object that contains a list with the competitive tiers and the HTTP status code
     */
    override suspend fun getCompetitiveTiers(language: LanguageCode): CompetitiveTiers {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.CompetitiveTiers.COMPETITIVE_TIERS),
            params = params
        )
    }

    /**
     * Get a competitive tier by its UUID.
     * Correspondence to the API route: [/competitive-tiers/:uuid](https://valorant-api.com/v1/competitive-tiers/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the competitive tier
     *
     * @return [CompetitiveTier] object that contains the competitive tier
     */
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

    /**
     * Get the content tiers of the game.
     * Correspondence to the API route: [/content-tiers](https://valorant-api.com/v1/content-tiers)
     *
     * @param language The language of the response. Default is English
     *
     * @return [ContentTiers] object that contains a list with the content tiers and the HTTP status code
     */
    override suspend fun getContentTiers(language: LanguageCode): ContentTiers {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.ContentTiers.CONTENT_TIERS),
            params = params
        )
    }

    /**
     * Get a content tier by its UUID.
     * Correspondence to the API route: [/content-tiers/:uuid](https://valorant-api.com/v1/content-tiers/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the content tier
     *
     * @return [ContentTier] object that contains the content tier
     */
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

    /**
     * Get the contracts of the game.
     * Correspondence to the API route: [/contracts](https://valorant-api.com/v1/contracts)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Contracts] object that contains a list with the contracts and the HTTP status code
     */
    override suspend fun getContracts(language: LanguageCode): Contracts {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Contracts.CONTRACTS),
            params = params
        )
    }

    /**
     * Get a contract by its UUID.
     * Correspondence to the API route: [/contracts/:uuid](https://valorant-api.com/v1/contracts/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the contract
     *
     * @return [Contract] object that contains the contract
     */
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

    /**
     * Get the currencies of the game.
     * Correspondence to the API route: [/currencies](https://valorant-api.com/v1/currencies)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Currencies] object that contains a list with the currencies and the HTTP status code
     */
    override suspend fun getCurrencies(language: LanguageCode): Currencies {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Currencies.CURRENCIES),
            params = params
        )
    }

    /**
     * Get a currency by its UUID.
     * Correspondence to the API route: [/currencies/:uuid](https://valorant-api.com/v1/currencies/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the currency
     *
     * @return [Currency] object that contains the currency
     */
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

    /**
     * Get the events of the game.
     * Correspondence to the API route: [/events](https://valorant-api.com/v1/events)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Events] object that contains a list with the events and the HTTP status code
     */
    override suspend fun getEvents(language: LanguageCode): Events {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Events.EVENTS),
            params = params
        )
    }

    /**
     * Get an event by its UUID.
     * Correspondence to the API route: [/events/:uuid](https://valorant-api.com/v1/events/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the event
     *
     * @return [Event] object that contains the event
     */
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

    /**
     * Get the gamemodes of the game.
     * Correspondence to the API route: [/gamemodes](https://valorant-api.com/v1/gamemodes)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Gamemodes] object that contains a list with the gamemodes and the HTTP status code
     */
    override suspend fun getGameModes(language: LanguageCode): Gamemodes {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Gamemodes.GAMEMODES),
            params = params
        )
    }

    /**
     * Get a gamemode by its UUID.
     * Correspondence to the API route: [/gamemodes/:uuid](https://valorant-api.com/v1/gamemodes/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the gamemode
     *
     * @return [Gamemode] object that contains the gamemode
     */
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

    /**
     * Get the equippables of the game.
     * Correspondence to the API route: [/gamemodes/equippables](https://valorant-api.com/v1/gamemodes/equippables)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Equippables] object that contains a list with the equippables and the HTTP status code
     */
    override suspend fun getGameModeEquippables(language: LanguageCode): Equippables {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Gamemodes.EQUIPPABLES),
            params = params
        )

    }

    /**
     * Get an equippable by its UUID.
     * Correspondence to the API route: [/gamemodes/equippables/:uuid](https://valorant-api.com/v1/gamemodes/equippables/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the equippable
     *
     * @return [Equippable] object that contains the equippable
     */
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

    /**
     * Get the gears of the game.
     * Correspondence to the API route: [/gears](https://valorant-api.com/v1/gears)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Gears] object that contains a list with the gears and the HTTP status code
     */
    override suspend fun getGears(language: LanguageCode): Gears {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Gear.GEARS),
            params = params
        )
    }

    /**
     * Get a gear by its UUID.
     * Correspondence to the API route: [/gears/:uuid](https://valorant-api.com/v1/gears/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the gear
     *
     * @return [Gear] object that contains the gear
     */
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

    /**
     * Get the level borders of the game.
     * Correspondence to the API route: [/level-borders](https://valorant-api.com/v1/level-borders)
     *
     * @param language The language of the response. Default is English
     *
     * @return [LevelBorders] object that contains a list with the level borders and the HTTP status code
     */
    override suspend fun getLevelBorders(language: LanguageCode): LevelBorders {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.LevelBorders.LEVEL_BORDERS),
            params = params
        )
    }

    /**
     * Get a level border by its UUID.
     * Correspondence to the API route: [/level-borders/:uuid](https://valorant-api.com/v1/level-borders/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the level border
     *
     * @return [LevelBorder] object that contains the level border
     */
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

    /**
     * Get the maps of the game.
     * Correspondence to the API route: [/maps](https://valorant-api.com/v1/maps)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Maps] object that contains a list with the maps and the HTTP status code
     */
    override suspend fun getMaps(language: LanguageCode): Maps {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Maps.MAPS),
            params = params
        )
    }

    /**
     * Get a map by its UUID.
     * Correspondence to the API route: [/maps/:uuid](https://valorant-api.com/v1/maps/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the map
     *
     * @return [Map] object that contains the map
     */
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

    /**
     * Get the player cards of the game.
     * Correspondence to the API route: [/playercards](https://valorant-api.com/v1/playercards)
     *
     * @param language The language of the response. Default is English
     *
     * @return [PlayerCards] object that contains a list with the player cards and the HTTP status code
     */
    override suspend fun getPlayerCards(language: LanguageCode): PlayerCards {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.PlayerCards.PLAYER_CARDS),
            params = params
        )
    }

    /**
     * Get a player card by its UUID.
     * Correspondence to the API route: [/playercards/:uuid](https://valorant-api.com/v1/playercards/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the player card
     *
     * @return [PlayerCard] object that contains the player card
     */
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

    /**
     * Get the player titles of the game.
     * Correspondence to the API route: [/playertitles](https://valorant-api.com/v1/playertitles)
     *
     * @param language The language of the response. Default is English
     *
     * @return [PlayerTitles] object that contains a list with the player titles and the HTTP status code
     */
    override suspend fun getPlayerTitles(language: LanguageCode): PlayerTitles {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.PlayerTitles.PLAYER_TITLES),
            params = params
        )
    }

    /**
     * Get a player title by its UUID.
     * Correspondence to the API route: [/playertitles/:uuid](https://valorant-api.com/v1/playertitles/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the player title
     *
     * @return [PlayerTitle] object that contains the player title
     */
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

    /**
     * Get the seasons of the game.
     * Correspondence to the API route: [/seasons](https://valorant-api.com/v1/seasons)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Seasons] object that contains a list with the seasons and the HTTP status code
     */
    override suspend fun getSeasons(language: LanguageCode): Seasons {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Seasons.SEASONS),
            params = params
        )
    }


    /**
     * Get a season by its UUID.
     * Correspondence to the API route: [/seasons/:uuid](https://valorant-api.com/v1/seasons/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the season
     *
     * @return [Season] object that contains the season
     */
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

    /**
     * Get the competitive seasons of the game.
     * Correspondence to the API route: [/seasons/competitive](https://valorant-api.com/v1/seasons/competitive)
     *
     * @return [CompetitiveSeasons] object that contains a list with the competitive seasons and the HTTP status code
     */
    override suspend fun getCompetitiveSeasons(): CompetitiveSeasons {
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Seasons.SEASONS_COMPETITIVE),
            params = mutableMapOf()
        )

    }

    /**
     * Get a competitive season by its UUID.
     * Correspondence to the API route: [/seasons/competitive/:uuid](https://valorant-api.com/v1/seasons/competitive/{uuid})
     *
     * @param uuid The UUID of the competitive season
     *
     * @return [CompetitiveSeason] object that contains the competitive season
     */
    override suspend fun getCompetitiveSeasonByUuid(
        uuid: String
    ): CompetitiveSeason {
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Seasons.SEASON_COMPETITIVE, uuid),
            params = mutableMapOf()
        )

    }

    /**
     * Get the sprays of the game.
     * Correspondence to the API route: [/sprays](https://valorant-api.com/v1/sprays)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Sprays] object that contains a list with the sprays and the HTTP status code
     */
    override suspend fun getSprays(language: LanguageCode): Sprays {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Sprays.SPRAYS),
            params = params
        )
    }

    /**
     * Get a spray by its UUID.
     * Correspondence to the API route: [/sprays/:uuid](https://valorant-api.com/v1/sprays/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the spray
     *
     * @return [Spray] object that contains the spray
     */
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

    /**
     * Get the spray levels of the game.
     * Correspondence to the API route: [/sprays/levels](https://valorant-api.com/v1/sprays/levels)
     *
     * @param language The language of the response. Default is English
     *
     * @return [SprayLevels] object that contains a list with the spray levels and the HTTP status code
     */
    override suspend fun getSprayLevels(language: LanguageCode): SprayLevels {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Sprays.LEVELS),
            params = params
        )
    }

    /**
     * Get a spray level by its UUID.
     * Correspondence to the API route: [/sprays/levels/:uuid](https://valorant-api.com/v1/sprays/levels/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the spray level
     *
     * @return [SprayLevel] object that contains the spray level
     */
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

    /**
     * Get the themes of the game.
     * Correspondence to the API route: [/themes](https://valorant-api.com/v1/themes)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Themes] object that contains a list with the themes and the HTTP status code
     */
    override suspend fun getThemes(language: LanguageCode): Themes {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Themes.THEMES),
            params = params
        )
    }

    /**
     * Get a theme by its UUID.
     * Correspondence to the API route: [/themes/:uuid](https://valorant-api.com/v1/themes/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the theme
     *
     * @return [Theme] object that contains the theme
     */
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

    /**
     * Get the weapons of the game.
     * Correspondence to the API route: [/weapons](https://valorant-api.com/v1/weapons)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Weapons] object that contains a list with the weapons and the HTTP status code
     */
    override suspend fun getWeapons(language: LanguageCode): Weapons {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Weapons.WEAPONS),
            params = params
        )

    }

    /**
     * Get a weapon by its UUID.
     * Correspondence to the API route: [/weapons/:uuid](https://valorant-api.com/v1/weapons/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the weapon
     *
     * @return [Weapon] object that contains the weapon
     */
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

    /**
     * Get the weapon skins of the game.
     * Correspondence to the API route: [/weapons/skins](https://valorant-api.com/v1/weapons/skins)
     *
     * @param language The language of the response. Default is English
     *
     * @return [WeaponSkins] object that contains a list with the weapon skins and the HTTP status code
     */
    override suspend fun getWeaponSkins(language: LanguageCode): WeaponSkins {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Weapons.SKINS),
            params = params
        )
    }

    /**
     * Get a weapon skin by its UUID.
     * Correspondence to the API route: [/weapons/skins/:uuid](https://valorant-api.com/v1/weapons/skins/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the weapon skin
     *
     * @return [WeaponSkin] object that contains the weapon skin
     */
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

    /**
     * Get the weapon skin chromas of the game.
     * Correspondence to the API route: [/weapons/chromas](https://valorant-api.com/v1/weapons/chromas)
     *
     * @param language The language of the response. Default is English
     *
     * @return [Chromas] object that contains a list with the weapon skin chromas and the HTTP status code
     */
    override suspend fun getWeaponSkinChromas(language: LanguageCode): Chromas {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Weapons.CHROMAS),
            params = params
        )
    }

    /**
     * Get a weapon skin chroma by its UUID.
     * Correspondence to the API route: [/weapons/chromas/:uuid](https://valorant-api.com/v1/weapons/chromas/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the weapon skin chroma
     *
     * @return [Chroma] object that contains the weapon skin chroma
     */
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

    /**
     * Get the weapon skin levels of the game.
     * Correspondence to the API route: [/weapons/levels](https://valorant-api.com/v1/weapons/levels)
     *
     * @param language The language of the response. Default is English
     *
     * @return A list with the weapon skin levels
     */
    override suspend fun getWeaponSkinLevels(language: LanguageCode): List<SkinLevel> {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()

        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Weapons.LEVELS),
            params = params
        )
    }

    /**
     * Get a weapon skin level by its UUID.
     * Correspondence to the API route: [/weapons/levels/:uuid](https://valorant-api.com/v1/weapons/levels/{uuid})
     *
     * @param language The language of the response. Default is English
     * @param uuid The UUID of the weapon skin level
     *
     * @return [SkinLevel] object that contains the weapon skin level
     */
    override suspend fun getWeaponSkinLevelByUuid(
        language: LanguageCode,
        uuid: String
    ): SkinLevel {
        val params = mutableMapOf<String, String>()
        params["language"] = language.toString()
        return makeApiCall(
            client = client,
            apiUrl = buildUuidUrl(HttpRoutes.Weapons.LEVEL, uuid),
            params = params
        )
    }

    /**
     * Get the actual game version.
     * Correspondence to the API route: [/version](https://valorant-api.com/v1/version)
     *
     * @return [Version] object that contains the actual game version and some other information about the branch, engine version...
     */
    override suspend fun getVersion(): Version {
        return makeApiCall(
            client = client,
            apiUrl = buildUrl(HttpRoutes.Version.VERSION),
            params = mutableMapOf()
        )
    }
}