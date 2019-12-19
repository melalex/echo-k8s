package com.melalex.echo.support.impl

import com.melalex.echo.support.TimeProvider
import org.springframework.stereotype.Component
import java.time.Clock
import java.time.ZonedDateTime

@Component
class TimeProviderImpl(
        private val clock: Clock
) : TimeProvider {

    override fun provide(): ZonedDateTime = ZonedDateTime.now(clock)
}
