package com.melalex.echo.controller

import com.melalex.echo.domain.EchoEntity
import com.melalex.echo.service.EchoService
import com.melalex.echo.util.getIp
import org.springframework.data.domain.PageRequest
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Controller
@RequestMapping("/v1/echo")
class EchoController(
        private val echoService: EchoService
) {

    @PostMapping
    fun echo(
            @RequestBody content: String,
            @RequestHeader(name = "Content-Type", defaultValue = "text/plain") type: String,
            serverHttpRequest: ServerHttpRequest
    ): Mono<ResponseEntity<String>> =
            echoService.record(content, type, getIp(serverHttpRequest))
                    .map {
                        ResponseEntity.ok()
                                .contentType(MediaType.parseMediaType(it.contentType))
                                .body(it.content)
                    }

    @ResponseBody
    @GetMapping("/history")
    fun history(
            @RequestParam(required = false, defaultValue = "0") page: Int,
            @RequestParam(required = false, defaultValue = "20") size: Int
    ): Flux<EchoEntity> = echoService.history(PageRequest.of(page, size))
}
