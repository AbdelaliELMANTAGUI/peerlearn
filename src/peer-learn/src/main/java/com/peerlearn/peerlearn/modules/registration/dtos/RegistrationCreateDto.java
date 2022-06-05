package com.peerlearn.peerlearn.modules.registration.dtos;

import com.peerlearn.peerlearn.constants.GroupRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegistrationCreateDto {

    private Long group_id;
    private Long user_id;
    private GroupRole role;

}
