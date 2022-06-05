package com.peerlearn.peerlearn.modules.registration.dtos;

import com.peerlearn.peerlearn.constants.GroupRole;
import com.peerlearn.peerlearn.modules.group.dtos.GroupGetDto;
import com.peerlearn.peerlearn.modules.user.User;
import com.peerlearn.peerlearn.modules.user.dtos.UserGetDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegistrationGetDto {
    private Long id;
    private GroupGetDto group;
    private UserGetDto user;
    private GroupRole role;
    private Date created_at;

}
