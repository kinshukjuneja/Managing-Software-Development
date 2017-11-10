package team.awesome.pet.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.awesome.pet.model.User;
import team.awesome.pet.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepo;

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    User user = this.userRepo.findByUserName(userName);
    /**
     * Might need to create roles here if needed
     */
    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    return new org.springframework.security.core.userdetails.User(user.getUsername(),
        user.getPassword(), grantedAuthorities);
  }

}
