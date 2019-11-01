package com.vela.developermanagementservice.infrastructure.security;

import com.vela.developermanagementservice.infrastructure.persistence.entities.UserDbEntity;
import com.vela.developermanagementservice.infrastructure.persistence.repository.UserDbEntityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDbEntityRepository userDbEntityRepository;

    private static Logger logger = LogManager.getLogger(UserDetailsServiceImpl.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("NOW STARTING AUTHENTICATION AT USER DETAILS SERVICE");

        logger.info("DONE WITH AUTHENTICATION AT USER DETAILS SERVICE");
        List<String> privileges=new ArrayList<>();
       Optional<UserDbEntity> account = Optional.of(userDbEntityRepository.findByEmail(email));
        System.out.println("from database: "+account.get().getEmail());

        if(!account.isPresent()){
           throw new UsernameNotFoundException("User not Found");
           //cccc
       }
        privileges.add(account.get().getPrivilege$developers_management_service().getName());
        return new User(account.get().getEmail(), account.get().getPassword(), getGrantedAuthorities(privileges));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String privilege : privileges)
            authorities.add(new SimpleGrantedAuthority(privilege));

        return authorities;
    }

}