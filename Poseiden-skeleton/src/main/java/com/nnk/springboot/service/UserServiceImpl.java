package com.nnk.springboot.service;

import com.nnk.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /**
     * Recherche des données utilisateurs
     * @param username identifiant de l'utilisateur
     * @return enregistrement de l'utilisateur
     * @throws UsernameNotFoundException Exception si utilisateur non trouvé
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // supplier
        return userRepository.findByusername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
