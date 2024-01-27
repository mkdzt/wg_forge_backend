package com.example.wg_forge_backend.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController {

    @GetMapping("/ping")
    suspend fun ping():ResponseEntity<String>{
        return ResponseEntity.ok().body("Cats Service. Version 0.1")
    }
}