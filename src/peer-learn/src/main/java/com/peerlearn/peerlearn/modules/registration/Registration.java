package com.peerlearn.peerlearn.modules.registration;

import com.peerlearn.peerlearn.constants.GroupRole;
import com.peerlearn.peerlearn.modules.group.Group;
import com.peerlearn.peerlearn.modules.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id",referencedColumnName = "id")
    private Group group;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    private GroupRole role;

    @Column
    @CreationTimestamp
    private Date created_at;

}
