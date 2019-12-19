package com.melalex.echo.service

import com.melalex.echo.domain.EchoEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface EchoService {

    fun record(content: String, type: String, ip: String): Mono<EchoEntity>

    fun history(pageable: Pageable): Flux<EchoEntity>
}
