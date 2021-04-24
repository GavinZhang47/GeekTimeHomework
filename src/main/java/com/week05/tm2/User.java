package com.week05.tm2;

public class User {

    private String username;

    private Account account;

    public User() {
    }

    public User(String username, Account account) {
        this.username = username;
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", account=" + account +
                '}';
    }
}
