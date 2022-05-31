package com.peerlearn.peerlearn.response.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginSuccessResponse {

    private String message;
    private String token;
    private String timestamp;

}
