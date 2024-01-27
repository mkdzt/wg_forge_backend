package com.example.wg_forge_backend.controllers

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@ExtendWith(SpringExtension::class)
@WebFluxTest(controllers = [PingController::class])
class PingControllerTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @BeforeEach
    fun initClient(context: ApplicationContext) {
        webTestClient = WebTestClient
            .bindToApplicationContext(context)
            .build()
    }

    @Test
    fun `call ping endpoint returns 200`() {
        webTestClient.get().uri("/ping")
            .exchange()
            .expectStatus().isOk
            .expectBody().returnResult()
            .responseBody.toString().contains("\"Cats Service. Version 0.1\"")
    }
}