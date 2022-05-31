package com.peerlearn.peerlearn.modules.user;

import com.peerlearn.peerlearn.modules.user.dtos.UserGetDto;
import com.peerlearn.peerlearn.modules.user.dtos.UserSignupDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {

    abstract User userSignupDtoToUser(UserSignupDto u);
    abstract UserGetDto userToUserGetDto(User u);
}
