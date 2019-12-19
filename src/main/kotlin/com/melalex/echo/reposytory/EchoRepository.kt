package com.melalex.echo.reposytory

import com.melalex.echo.domain.EchoEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface EchoRepository : ReactiveMongoRepository<EchoEntity, String> {

    fun findAllBy(pageable: Pageable): Flux<EchoEntity>
}
