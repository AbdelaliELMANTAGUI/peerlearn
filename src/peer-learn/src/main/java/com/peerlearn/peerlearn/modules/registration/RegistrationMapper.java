package com.peerlearn.peerlearn.modules.registration;

import com.peerlearn.peerlearn.modules.registration.dtos.RegistrationCreateDto;
import com.peerlearn.peerlearn.modules.registration.dtos.RegistrationGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class RegistrationMapper {
    abstract RegistrationGetDto toRegistrationGetDto(Registration registration);
    @Mapping(target = "user",expression = "java(new com.peerlearn.peerlearn.modules.user.User(r.getUser_id()))")
    @Mapping(target = "group",expression = "java(new com.peerlearn.peerlearn.modules.group.Group(r.getGroup_id()))")
    abstract Registration fromRegistrationCreateDto(RegistrationCreateDto r);
}
