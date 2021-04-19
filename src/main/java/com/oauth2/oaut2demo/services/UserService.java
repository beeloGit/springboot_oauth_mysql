package com.oauth2.oaut2demo.services;

import com.oauth2.oaut2demo.Modals.Permission;
import com.oauth2.oaut2demo.Modals.User;
import com.oauth2.oaut2demo.Modals.UserRole;
import com.oauth2.oaut2demo.repositories.PermissionRepository;
import com.oauth2.oaut2demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.oauth2.oaut2demo.Wrappers.UserWrapper;
import com.oauth2.oaut2demo.Wrappers.PermissionWrapper;
import com.oauth2.oaut2demo.Wrappers.RoleWrapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PermissionRepository permissionRepo;

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void generateBcryptHashKey(String nonEncryptedText) {
        String encryptedText = passwordEncoder().encode(nonEncryptedText);
        System.out.println(encryptedText);

    }

    public User findByUserName(String name) {
        return userRepository.findByUsername(name);
    }

    public UserWrapper buildLoggedInUserWrapper(User dbUser) {
        UserWrapper user = new UserWrapper(dbUser);
        List<PermissionWrapper> permissionWrappers = new ArrayList<>();
        List<RoleWrapper> roleWrappers = new ArrayList<>();
        List<Permission> userPermissions = getIdenticalUserPermissions(dbUser);

        for (UserRole role : dbUser.getRoles()) {
            RoleWrapper roleWrapper = new RoleWrapper(role.getRole());
            roleWrappers.add(roleWrapper);

            String commaSeparatedRoles = "";
            commaSeparatedRoles = (commaSeparatedRoles) + (role.getRole().getName() + ",");
            commaSeparatedRoles = commaSeparatedRoles.substring(0, commaSeparatedRoles.lastIndexOf(","));
            user.setCommaSeparatedRoles(commaSeparatedRoles);
        }

        for (Permission per : userPermissions) {
            PermissionWrapper permissionWrapper = new PermissionWrapper(per);
            permissionWrappers.add(permissionWrapper);
        }
        user.setPermissions(permissionWrappers);
        user.setRoles(roleWrappers);

        return user;
    }

    private List<Permission> getIdenticalUserPermissions(User user) {
        List<Permission> allPermissions = new ArrayList<>();
        List<Permission> rolePermissions = permissionRepo.findAllUserRolePermissions(user.getId());
        List<Permission> userPermissions = permissionRepo.findAllUserPermissions(user.getId());
        allPermissions.addAll(rolePermissions);
        allPermissions.addAll(userPermissions);

        Set<Permission> identicalPermissionsSet = new HashSet<>(allPermissions);
        List<Permission> identicalPermissions = new ArrayList<>(identicalPermissionsSet);

        return identicalPermissions;
    }

}
