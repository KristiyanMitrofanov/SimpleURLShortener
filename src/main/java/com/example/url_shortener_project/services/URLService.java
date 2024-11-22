package com.example.url_shortener_project.services;

import com.example.url_shortener_project.DTOs.URLResponse;

public interface URLService {

    String shorten(String url);

    String resolve(String hash);
}
