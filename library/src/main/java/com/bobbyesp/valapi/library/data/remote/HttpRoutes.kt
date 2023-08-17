package com.bobbyesp.valapi.library.data.remote

object HttpRoutes {
    const val VALORANT_API_BASE = "https://valorant-api.com/v1"

    object Agents {
        const val AGENTS = "agents"
        const val AGENT = "agents/{uuid}"
    }

    object Buddies {
        const val BUDDIES = "buddies"
        const val BUDDY = "buddies/{uuid}"

        const val LEVELS = "buddies/levels"
        const val LEVEL = "buddies/levels/{uuid}"
    }

    object Bundles {
        const val BUNDLES = "bundles"
        const val BUNDLE = "bundles/{uuid}"
    }

    object Ceremonies {
        const val CEREMONIES = "ceremonies"
        const val CEREMONY = "ceremonies/{uuid}"
    }

    object CompetitiveTiers {
        const val COMPETITIVE_TIERS = "competitivetiers"
        const val COMPETITIVE_TIER = "competitivetiers/{uuid}"
    }

    object ContentTiers {
        const val CONTENT_TIERS = "contenttiers"
        const val CONTENT_TIER = "contenttiers/{uuid}"
    }

    object Contracts {
        const val CONTRACTS = "contracts"
        const val CONTRACT = "contracts/{uuid}"
    }

    object Currencies {
        const val CURRENCIES = "currencies"
        const val CURRENCY = "currencies/{uuid}"
    }

    object Events {
        const val EVENTS = "events"
        const val EVENT = "events/{uuid}"
    }

    object Gamemodes {
        const val GAMEMODES = "gamemodes"
        const val GAMEMODE = "gamemodes/{uuid}"

        const val EQUIPPABLES = "gamemodes/equippables"
        const val EQUIPPABLE = "gamemodes/equippables/{uuid}"
    }

    object Gear {
        const val GEARS = "gear"
        const val GEAR = "gear/{uuid}"
    }

    object LevelBorders {
        const val LEVEL_BORDERS = "levelborders"
        const val LEVEL_BORDER = "levelborders/{uuid}"
    }

    object Maps {
        const val MAPS = "maps"
        const val MAP = "maps/{uuid}"
    }

    object PlayerCards {
        const val PLAYER_CARDS = "playercards"
        const val PLAYER_CARD = "playercards/{uuid}"
    }

    object PlayerTitles {
        const val PLAYER_TITLES = "playertitles"
        const val PLAYER_TITLE = "playertitles/{uuid}"
    }

    object Seasons {
        const val SEASONS = "seasons"
        const val SEASON = "seasons/{uuid}"

        const val SEASONS_COMPETITIVE = "seasons/competitive"
        const val SEASON_COMPETITIVE = "seasons/competitive/{uuid}"
    }

    object Sprays {
        const val SPRAYS = "sprays"
        const val SPRAY = "sprays/{uuid}"

        const val LEVELS = "sprays/levels"
        const val LEVEL = "sprays/levels/{uuid}"
    }

    object Themes {
        const val THEMES = "themes"
        const val THEME = "themes/{uuid}"
    }

    object Weapons {
        const val WEAPONS = "weapons"
        const val WEAPON = "weapons/{uuid}"

        const val SKINS = "weapons/skins"
        const val SKIN = "weapons/skins/{uuid}"

        const val CHROMAS = "weapons/skinchromas"
        const val CHROMA = "weapons/skinchromas/{uuid}"

        const val LEVELS = "weapons/skinlevels"
        const val LEVEL = "weapons/skinlevels/{uuid}"
    }

    object Version {
        const val VERSION = "version"
    }
}