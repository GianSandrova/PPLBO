package com.blog.vo;

public class Result {
    int result;
    String message; // Ubah massage menjadi message

    public Result() {
    }

    public Result(int result, String message) { // Ubah massage menjadi message
        this.result = result;
        this.message = message; // Ubah massage menjadi message
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
