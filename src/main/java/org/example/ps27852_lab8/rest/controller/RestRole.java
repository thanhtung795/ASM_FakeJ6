package org.example.ps27852_lab8.rest.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Role;
import org.example.ps27852_lab8.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/roles")
public class RestRole {
    private final RoleService roleService;


    @GetMapping
    public List<Role> listRoles() {
        return roleService.findAll();
    }
}
