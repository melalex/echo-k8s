package com.melalex.echo.util

import org.springframework.http.server.reactive.ServerHttpRequest

const val DEFAULT_IP = "<UNKNOWN IP>"

fun getIp(request: ServerHttpRequest): String = request.remoteAddress?.address?.hostAddress ?: DEFAULT_IP
