package com.demo.mylibrary;

public class Author {
    private String title;
    private String info;
    private int resId;

    public Author(String title, String info, int resId) {
        this.title = title;
        this.info = info;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getResId() {
        return resId;
    }

    @Override
    public String toString() {
        return title;
    }
}
