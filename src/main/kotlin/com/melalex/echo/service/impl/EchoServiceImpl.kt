package com.melalex.echo.service.impl

import com.melalex.echo.domain.EchoEntity
import com.melalex.echo.reposytory.EchoRepository
import com.melalex.echo.service.EchoService
import com.melalex.echo.support.TimeProvider
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class EchoServiceImpl(
        private val echoRepository: EchoRepository,
        private val timeProvider: TimeProvider
) : EchoService {

    override fun record(content: String, type: String, ip: String): Mono<EchoEntity> =
            echoRepository.save(EchoEntity(
                    timestamp = timeProvider.provide().toEpochSecond(),
                    ip = ip,
                    contentType = type,
                    content = content
            ))

    override fun history(pageable: Pageable): Flux<EchoEntity> = echoRepository.findAllBy(pageable)
}
