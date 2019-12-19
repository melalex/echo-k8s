package com.melalex.echo.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class EchoEntity(

        @Id
        val id: String? = null,
        val timestamp: Long,
        val ip: String,
        val contentType: String,
        val content: String
)
