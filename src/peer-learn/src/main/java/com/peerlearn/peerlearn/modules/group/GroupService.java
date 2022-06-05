package com.peerlearn.peerlearn.modules.group;

import com.peerlearn.peerlearn.constants.GroupRole;
import com.peerlearn.peerlearn.modules.group.dtos.GroupCreateDto;
import com.peerlearn.peerlearn.modules.group.dtos.GroupGetDto;
import com.peerlearn.peerlearn.modules.group.dtos.GroupUpdateDto;
import com.peerlearn.peerlearn.modules.registration.RegistrationService;
import com.peerlearn.peerlearn.modules.registration.dtos.RegistrationCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class GroupService {

    GroupRepository groupRepository;
    GroupMapper groupMapper;
    RegistrationService registrationService;

    public GroupService(GroupRepository groupRepository, GroupMapper groupMapper, RegistrationService registrationService) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
        this.registrationService = registrationService;
    }

    public GroupGetDto create(GroupCreateDto groupCreateDto, @NotNull Long user_id){
        Group group = groupRepository.save( groupMapper.fromGroupCreateDto(groupCreateDto));
        RegistrationCreateDto registration = new RegistrationCreateDto(group.getId(),user_id, GroupRole.ADMIN);
        registrationService.create(registration);
        return groupMapper.toGroupGetDto(group);
    }

    public GroupGetDto patch(Group group,GroupUpdateDto groupUpdateDto){
        groupMapper.patchGroup(groupMapper.fromGroupUpdateDto(groupUpdateDto,group.getId()),group);
        return groupMapper.toGroupGetDto(group);
    }

    public GroupGetDto getOne(Long gid){
        return groupMapper.toGroupGetDto(groupRepository.findById(gid).orElseThrow(()-> new RuntimeException("not found entiry")));// TODO replace with exception
    }

    public Page<GroupGetDto> getAll(Pageable pg){
        Page<Group> page = groupRepository.findAll(pg);
        return new PageImpl<GroupGetDto>(groupMapper.toGroupGetDtoList(page.getContent()),pg,page.getTotalElements());
    }
    public GroupGetDto delete(Long gid){
        GroupGetDto group = getOne(gid);
        groupRepository.deleteById(gid);
        return group;// TODO replace with exception
    }
}
