package spring.part_2.service;

import spring.part_2.repository.RoleRepository;
import spring.part_2.unit.Role;
import spring.part_2.unit.User;
import spring.part_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public void save(UserRepr userRepr) {
        User user = new User();
        user.setId(userRepr.getId());
        user.setUsername(userRepr.getUsername());
        user.setPassword(passwordEncoder.encode(userRepr.getPassword()));
        user.setRoles(userRepr.getRoles());
        userRepository.save(user);
    }

    public void registration(UserRepr userRepr) {
        User user = new User();
        user.setId(userRepr.getId());
        user.setUsername(userRepr.getUsername());
        user.setPassword(passwordEncoder.encode(userRepr.getPassword()));
        user.setRoles(Arrays.asList(roleRepository.findOneByName("ROLE_GUEST")));
        userRepository.save(user);
    }

    public List<UserRepr> findAll() {
        return userRepository.findAll().stream()
                .map(UserRepr::new)
                .collect(Collectors.toList());
    }

    public Optional<UserRepr> findById(Long id) {
        return userRepository.findById(id)
                .map(UserRepr::new);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
