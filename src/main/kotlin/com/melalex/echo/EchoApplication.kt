package com.melalex.echo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.Clock
import java.time.ZoneId


@SpringBootApplication
class EchoApplication {

    @Bean
    fun zoneId(): ZoneId = ZoneId.systemDefault()

    @Bean
    fun clock(): Clock = Clock.system(zoneId())
}

fun main(args: Array<String>) {
    runApplication<EchoApplication>(*args)
}
