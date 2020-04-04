package com.sog.spring.security.learnspringsecurity.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.sog.spring.security.learnspringsecurity.security.ApplicationPermission.*;

public enum ApplicationRole {

    STUDENT(Sets.newHashSet()),
    COURSE(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE));

    final Set<ApplicationPermission> permissions;

    ApplicationRole(Set<ApplicationPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationPermission> getPermissions() {
        return permissions;
    }
}
