package org.example.ps27852_lab8.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Authority;
import org.example.ps27852_lab8.service.AuthorityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/authorities")
public class RestAuthority {
    private final AuthorityService authorityService;

    @GetMapping
    public List<Authority> listAuthorities(@RequestParam("admin") Optional<Boolean> admin) {
        if (admin.orElse(false)) {
            return authorityService.getAllAuthoritiesOfAdmin();
        }
        return authorityService.getAllAuthorities();
    }
    @PostMapping
    public Authority createAuthority(@RequestBody Authority authority) {
        return authorityService.saveAuthority(authority);
    }
    @DeleteMapping("/{id}")
    public void deleteAuthority(@PathVariable Integer id) {
        authorityService.deleteAuthority(id);
    }
}
