package com.example.githubclient2.service;

import com.example.githubclient2.dto.Repository;
import com.example.githubclient2.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class GitHubApiService {

    @Value("${github.api.url}")
    private String GitHubApiUrl;

    @Value("${github.api.token}")
    private String GitHubApiToken;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GitHubApiService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    @Async("taskExecutor")
    public CompletableFuture<List<Repository>> getGitHubApi(String username) {
        return CompletableFuture.supplyAsync(()->{
            String url = GitHubApiUrl + "/users/" + username + "/repos";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", "Bearer "+GitHubApiToken);

            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            try {
                return objectMapper.readValue(response.getBody(),new TypeReference<List<Repository>>(){});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @Async("taskExecutor")
    public CompletableFuture<List<User>> getUserFollowers(String username) {
        return CompletableFuture.supplyAsync(()->{
            String url = GitHubApiUrl + "/users/" + username + "/followers";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", "Bearer "+GitHubApiToken);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            try {
                return objectMapper.readValue(response.getBody(),new TypeReference<List<User>>(){});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Async("taskExecutor")
    public CompletableFuture<List<User>> getUserFollowings(String username) {
        return CompletableFuture.supplyAsync(()->{
            String url = GitHubApiUrl + "/users/" + username + "/followings";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", "Bearer "+GitHubApiToken);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            try {
                return objectMapper.readValue(response.getBody(),new TypeReference<List<User>>(){});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    


}
