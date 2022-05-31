package com.peerlearn.peerlearn.mappers;

import com.peerlearn.peerlearn.modules.user.User;
import com.peerlearn.peerlearn.modules.user.dtos.UserLoginDto;
import org.mapstruct.Mapper;

@Mapper
public abstract class DtoMapper {
    abstract User userLoginDtoToUser(UserLoginDto userLoginDto);
}
