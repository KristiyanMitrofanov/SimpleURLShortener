package com.example.url_shortener_project.services;

import com.example.url_shortener_project.exceptions.HashUnknownException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class URLServiceImpl implements URLService {

    private final RedisTemplate<String, String> redisTemplate;

    private final MessageDigest digest = MessageDigest.getInstance("SHA-256");

    public URLServiceImpl(RedisTemplate<String, String> template) throws NoSuchAlgorithmException {
        redisTemplate = template;
    }

    @Override
    public String shorten(String url) {
        String hash = hash(url);
        redisTemplate.opsForValue().set(hash, url);
        return hash;
    }


    private String hash(String url) {
        return hash(url, 6);
    }

    private String hash(String url, int length) {
        byte[] bytes = digest.digest(url.getBytes());
        String hash = String.format("%32x", new BigInteger(1, bytes));
        return hash.substring(0, length);
    }

    @Override
    public String resolve(String hash) {
        String result = redisTemplate.opsForValue().get(hash);
        if (result != null) {
            return result;
        }
        throw new HashUnknownException("Hash not found");
    }
}
