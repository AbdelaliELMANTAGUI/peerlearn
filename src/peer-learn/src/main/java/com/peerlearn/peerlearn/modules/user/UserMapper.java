package com.peerlearn.peerlearn.modules.user;

import com.peerlearn.peerlearn.modules.user.dtos.UserGetDto;
import com.peerlearn.peerlearn.modules.user.dtos.UserSignupDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {

    abstract User fromUserSignupDto(UserSignupDto u);
    abstract UserGetDto toUserGetDto(User u);
}
