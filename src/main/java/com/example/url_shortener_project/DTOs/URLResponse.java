package com.example.url_shortener_project.DTOs;

public class URLResponse {

    public String hash;

    public URLResponse(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }
}
