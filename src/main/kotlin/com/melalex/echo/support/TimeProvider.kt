package com.melalex.echo.support

import java.time.ZonedDateTime

interface TimeProvider {

    fun provide(): ZonedDateTime
}
