package com.example.githubclient2.controller;

import com.example.githubclient2.dto.Repository;
import com.example.githubclient2.dto.User;
import com.example.githubclient2.service.GitHubApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class GitHubController {
    @Autowired
    private GitHubApiService gitHubApiService;

    @GetMapping("/github/{username}/all")
    public CompletableFuture<String> getUserDetails(@PathVariable String username) {

        CompletableFuture<List<Repository>> reposFuture = gitHubApiService.getGitHubApi(username);
        CompletableFuture<List<User>> followersFuture = gitHubApiService.getUserFollowers(username);
        CompletableFuture<List<User>> followingsFuture = gitHubApiService.getUserFollowings(username);

        return CompletableFuture.allOf(reposFuture, followersFuture, followingsFuture)
                .thenApply(v -> {
                    List<Repository> repos = reposFuture.join();
                    List<User> followers = followersFuture.join();
                    List<User> followings = followingsFuture.join();
                    return formatResult(repos,followers.size(),followings.size());
                });


    }

    private String formatResult(List<Repository> repos, int followersCount, int followingCount) {
        StringBuilder result = new StringBuilder();
        result.append("<ul>");
        for (Repository repo : repos) {
            result.append("<li>");
            result.append("<strong>").append(repo.getName()).append("</strong><br>");
            result.append("Followers: ").append(followersCount).append("<br>");
            result.append("Following: ").append(followingCount).append("<br>");
            result.append("</li>");
        }
        result.append("</ul>");
        return result.toString();
    }

}