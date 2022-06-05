package com.peerlearn.peerlearn.modules.registration;

import com.peerlearn.peerlearn.modules.group.Group;
import com.peerlearn.peerlearn.modules.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    Registration findRegistrationByGroupAndUser(Group g, User u);
}
