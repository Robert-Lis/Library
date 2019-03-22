package pl.library.Library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.library.Library.model.Role;
import pl.library.Library.model.User;
import pl.library.Library.repository.RoleRepository;
import pl.library.Library.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findRoleByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

//    private UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public void saveUser(User user) {
//        userRepository.save(user);
//    }
//
//    public void editUser(User user) {
//        userRepository.save(user);
//    }
//
//    public Optional<User> findUserById(Long id) {
//        return userRepository.findById(id);
//    }
//
////    public User loadUserByUsername(String username) throws UsernameNotFoundException {
////        return findUserByEmail(username)
////                .map(User::new)
////                .orElseThrow(() -> new UsernameNotFoundException("There is no such user"));
////    }
}
