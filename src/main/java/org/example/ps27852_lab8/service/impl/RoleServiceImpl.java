package org.example.ps27852_lab8.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Role;
import org.example.ps27852_lab8.repository.RoleRepository;
import org.example.ps27852_lab8.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
