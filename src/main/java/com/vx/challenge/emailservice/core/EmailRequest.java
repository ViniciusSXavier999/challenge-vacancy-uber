package com.vx.challenge.emailservice.core;

public record EmailRequest(String to, String subject, String body) {
}
