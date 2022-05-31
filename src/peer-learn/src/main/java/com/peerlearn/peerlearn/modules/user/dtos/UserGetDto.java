package com.peerlearn.peerlearn.modules.user.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
public class UserGetDto {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
}
