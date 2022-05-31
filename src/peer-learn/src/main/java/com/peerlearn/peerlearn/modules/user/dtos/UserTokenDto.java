package com.peerlearn.peerlearn.modules.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class UserTokenDto {
    private String token;
}
