package com.peerlearn.peerlearn.modules.registration;

import com.peerlearn.peerlearn.modules.group.Group;
import com.peerlearn.peerlearn.modules.registration.dtos.RegistrationCreateDto;
import com.peerlearn.peerlearn.modules.registration.dtos.RegistrationGetDto;
import com.peerlearn.peerlearn.modules.user.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    RegistrationMapper registrationMapper;
    RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationMapper registrationMapper, RegistrationRepository registrationRepository) {
        this.registrationMapper = registrationMapper;
        this.registrationRepository = registrationRepository;
    }

    public RegistrationGetDto create(RegistrationCreateDto registrationCreateDto){
        return registrationMapper.toRegistrationGetDto(
                registrationRepository.save(
                        registrationMapper.fromRegistrationCreateDto(registrationCreateDto)
                    )
                );
    }

    public RegistrationGetDto findRegistrationByGroupIDAndUserID(Long gid,Long uid){
        return registrationMapper.toRegistrationGetDto(registrationRepository.findRegistrationByGroupAndUser(new Group(gid),new User(uid)));
    }
}
