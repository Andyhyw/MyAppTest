package com.example.app3.event;

import com.example.app3.model.User;

public class MainActEvent {
    private User user;

    public MainActEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
