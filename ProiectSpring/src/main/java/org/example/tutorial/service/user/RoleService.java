package org.example.tutorial.service.user;

import lombok.RequiredArgsConstructor;
import org.example.tutorial.data.RoleRepository;
import org.example.tutorial.mapper.RoleMapper;
import org.example.tutorial.models.Role;
import org.example.tutorial.models.dto.RoleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    public RoleDto getRoleById(Integer id){
        return roleMapper.roleEntityToDto(roleRepository.findById(id).orElse(null));
    }

    public RoleDto findByRole(String role){
        return roleMapper.roleEntityToDto(roleRepository.findByRole(role));
    }

    public List<RoleDto> getAllRoles(){
        return roleMapper.roleListEntityToDto(roleRepository.findAll());
    }

    public RoleDto createRole(Role role){
        return roleMapper.roleEntityToDto(roleRepository.save(role));
    }

    public RoleDto updateRole(Role role){
        return roleMapper.roleEntityToDto(roleRepository.save(role));
    }

    public void deleteRole(Role role){
        roleRepository.delete(role);
    }

}