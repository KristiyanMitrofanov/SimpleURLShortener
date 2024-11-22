package com.example.url_shortener_project.controllers;

import com.example.url_shortener_project.DTOs.URLRequest;
import com.example.url_shortener_project.DTOs.URLResponse;
import com.example.url_shortener_project.services.URLService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class URLController {

    private final URLService service;

    public URLController(URLService service) {
        this.service = service;
    }

    @PostMapping
    public URLResponse shorten(@RequestBody URLRequest urlToShorten) {
        String hash = service.shorten(urlToShorten.getUrl());
        return new URLResponse(hash);
    }

    @GetMapping("/{hash}")
    public ResponseEntity<HttpStatus> getURL(@PathVariable String hash) {
        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.CONNECTION, "close")
                .location(URI.create(service.resolve(hash)))
                .build();
    }
}
