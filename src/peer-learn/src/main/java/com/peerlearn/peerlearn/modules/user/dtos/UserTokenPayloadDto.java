package com.peerlearn.peerlearn.modules.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenPayloadDto {
    private Long id;
    private String created_at;
}
