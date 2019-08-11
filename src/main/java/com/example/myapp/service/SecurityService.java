package com.example.myapp.service;

public interface SecurityService {

    String findLoggedUsername();

    void autoLogin(String username,String password);

}
