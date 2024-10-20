package com.example.journalquestionno6;

import java.util.List;

public class UserResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<User> data; // List of User objects

    // Getters
    public int getPage() {
        return page;
    }
    public int getPerPage() {
        return per_page;
    }
    public int getTotal() {
        return total;
    }
    public int getTotalPages() {
        return total_pages;
    }
    public List<User> getData() {
        return data;
    }
}
