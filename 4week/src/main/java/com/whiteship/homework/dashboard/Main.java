package com.whiteship.homework.dashboard;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String token = "src/main/resources/github.properties";
        String repository = "whiteship/live-study";

        GithubDashBoard githubDashBoard = new GithubDashBoard(token, repository);
        githubDashBoard.run();
    }
}
