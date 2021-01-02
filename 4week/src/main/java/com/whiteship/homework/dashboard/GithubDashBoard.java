package com.whiteship.homework.dashboard;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.*;

public class GithubDashBoard {

    GitHub github;
    String token;

    String repository;

    public GithubDashBoard(String token, String repository) {
        this.token = token;
        this.repository = repository;
    }

    public void run() throws IOException {
        connect();

        GHRepository ghRepository = github.getRepository(repository);
        Map<String, Integer> participant = new HashMap<>();
        List<GHIssue> issues = ghRepository.getIssues(GHIssueState.ALL);

        for (GHIssue issue : issues) {
            List<GHIssueComment> ghIssueComments = issue.getComments();

            Set<String> nameList = new HashSet<>();

            for (GHIssueComment ghIssueComment : ghIssueComments) {
                nameList.add(ghIssueComment.getUser().getLogin());
            }

            for(String name : nameList) {
                if(!participant.containsKey(name)) {
                    participant.put(name, 1);
                } else {
                    Integer integer = participant.get(name);
                    participant.put(name, ++integer);
                }
            }
        }

        System.out.println("Study 참여현황");

        participant.forEach((key, value) -> {
            double percent = (double) (value * 100) / 15;
            System.out.println(key + "   :   " + String.format("%.2f", percent) + "%" + "   -   참여 횟수   :   " + value + " / 15");
        });
    }

    private void connect() throws IOException {
        github = GitHubBuilder.fromPropertyFile(token).build();
    }
}
