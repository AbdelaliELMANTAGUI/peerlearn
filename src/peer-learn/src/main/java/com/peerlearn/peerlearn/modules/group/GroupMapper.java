package com.peerlearn.peerlearn.modules.group;

import com.peerlearn.peerlearn.modules.group.dtos.GroupCreateDto;
import com.peerlearn.peerlearn.modules.group.dtos.GroupGetDto;
import com.peerlearn.peerlearn.modules.group.dtos.GroupUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class GroupMapper {
    abstract Group fromGroupCreateDto(GroupCreateDto groupCreateDto);
    abstract GroupGetDto toGroupGetDto(Group group);
    abstract List<GroupGetDto> toGroupGetDtoList(List<Group> groups);
    abstract void patchGroup(Group s,@MappingTarget Group t);
    @Mapping(target = "id",expression = "java( gid )")
    abstract Group fromGroupUpdateDto(GroupUpdateDto g,Long gid);
}
