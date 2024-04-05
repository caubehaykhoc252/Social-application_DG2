package com.Social.application.DG2.entity;

import com.Social.application.DG2.entity.Enum.EnableType;
import com.Social.application.DG2.entity.Enum.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;
import java.util.*;

@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    @Column(length = 36)
    @NotNull
    private String id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")

    private Timestamp dateOfBirth;

    @Column(name = "mail")
    private String mail;

    @Column
    private String address;

    private String avatar;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleType roleType;

    @Enumerated(EnumType.STRING)
    @Column(name = "enable")
    private EnableType enableType;

    public Users() {
        this.id = UUID.randomUUID().toString();
        this.enableType = EnableType.TRUE;
        this.roleType = RoleType.USER;
    }

    @Column(name = "created_at")
    private Timestamp createAt;

    @Column(name = "updated_at")
    private Timestamp updateAt;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "follows",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "following_user_id")
    )
    @Column(name = "created_at")
    private Set<Users> followingUser = new HashSet<>();


//    @ElementCollection
//    @CollectionTable(name = "follows",
//            joinColumns = @JoinColumn(name = "user_id"),
//            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "following_user_id"})
//    )
//    @MapKeyJoinColumn(name = "following_user_id")
//    @Column(name = "created_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Map<Users, Timestamp> followingUser = new HashMap<>();

    @PrePersist
    protected void onCreate() {
        createAt = new Timestamp(new Date().getTime());
    }


//    @PreUpdate
//    protected void onUpdate() {
//        updateAt = new Timestamp(new Date().getTime());
//    }

}

