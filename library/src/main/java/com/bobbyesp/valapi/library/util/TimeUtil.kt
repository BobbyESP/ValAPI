package com.bobbyesp.valapi.library.util

import java.util.concurrent.TimeUnit

object TimeUtil {
    val ONE_WEEK_OLD = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7)
}