//package vn.kase.service.v1.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import vn.kase.domain.v1.user.User;
//import vn.kase.repository.v1.user.UserRepository;
//import vn.kase.security.CustomUserDetails;
//
//@Service
//@Transactional
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = this.userRepository.findByUsername(username);
//        return new CustomUserDetails(user);
//    }
//}