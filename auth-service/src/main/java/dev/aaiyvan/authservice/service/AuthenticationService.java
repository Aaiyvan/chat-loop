package dev.aaiyvan.authservice.service;

public interface AuthenticationService {

    String validate(long securityCode);

    long generateSecurityCode(long userId);
}