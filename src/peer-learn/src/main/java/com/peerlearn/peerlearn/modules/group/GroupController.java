package com.peerlearn.peerlearn.modules.group;

import com.peerlearn.peerlearn.constants.GroupRole;
import com.peerlearn.peerlearn.constants.PathVariables;
import com.peerlearn.peerlearn.constants.RequestAttributes;
import com.peerlearn.peerlearn.modules.group.dtos.GroupCreateDto;
import com.peerlearn.peerlearn.modules.group.dtos.GroupGetDto;
import com.peerlearn.peerlearn.modules.group.dtos.GroupUpdateDto;
import com.peerlearn.peerlearn.modules.registration.RegistrationService;
import com.peerlearn.peerlearn.modules.registration.dtos.RegistrationGetDto;
import com.peerlearn.peerlearn.modules.user.dtos.UserTokenPayloadDto;
import com.peerlearn.peerlearn.response.PageableResultResponse;
import com.peerlearn.peerlearn.response.ResultResponse;
import org.apache.coyote.Request;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {

    GroupService groupService;
    RegistrationService registrationService;
    GroupMapper groupMapper;

    public GroupController(GroupService groupService, RegistrationService registrationService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.registrationService = registrationService;
        this.groupMapper = groupMapper;
    }

    private boolean isGroupAdmin(Long gid, Long uid){
        RegistrationGetDto reg = registrationService.findRegistrationByGroupIDAndUserID(gid,uid);
        if(reg == null || !(reg.getRole() == GroupRole.ADMIN)) {
            throw new RuntimeException(" you are not an admin ");// TODO replace the exception
        }
        return true;
    }

    @PostMapping
    public ResultResponse<GroupGetDto> create(@Valid @RequestBody GroupCreateDto group, @RequestAttribute(RequestAttributes.USER_DATA) UserTokenPayloadDto userData){
        return new ResultResponse<>(
                groupService.create(group,userData.getId())
        );
    }

    @PatchMapping("/{"+ PathVariables.GROUP_PATH_VARIABLE +"}")
    public ResultResponse<GroupGetDto> patch(Group group,@Valid @RequestBody GroupUpdateDto groupUpdateDto, @RequestAttribute(RequestAttributes.USER_DATA) UserTokenPayloadDto userData, @PathVariable(PathVariables.GROUP_PATH_VARIABLE) Long gid){
        if(group.getId() == null ) throw new RuntimeException(" not found entity ");// TODO update the exception
        isGroupAdmin(gid,userData.getId());
        return new ResultResponse<>(groupService.patch(group,groupUpdateDto));
    }


    @GetMapping("/{"+ PathVariables.GROUP_PATH_VARIABLE +"}")
    public ResultResponse<GroupGetDto> getOne(@PathVariable(PathVariables.GROUP_PATH_VARIABLE) Long gid){
        return new ResultResponse<>(groupService.getOne(gid));
    }

    @GetMapping("/")
    public PageableResultResponse<GroupGetDto> getAll(Pageable page){
        return PageableResultResponse.of(groupService.getAll(page));
    }

    @DeleteMapping("/{"+ PathVariables.GROUP_PATH_VARIABLE +"}")
    public ResultResponse<String> delete(@PathVariable(PathVariables.GROUP_PATH_VARIABLE) Long gid){
        return new ResultResponse<>("Operation not allowed");//new ResultResponse<>(groupService.delete(gid));
    }

}
