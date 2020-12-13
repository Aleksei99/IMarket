package by.smuraha.market;

import by.smuraha.market.entity.Role;
import by.smuraha.market.entity.User;
import by.smuraha.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User setErrorJSONUser(Errors errors) {
        List<FieldError> errorList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        errorList.add(errors.getFieldError("name"));
        errorList.add(errors.getFieldError("surname"));
        errorList.add(errors.getFieldError("username"));
        errorList.add(errors.getFieldError("password"));
        for (FieldError field:errorList) {
            if(field!=null){
                strings.add(field.getDefaultMessage());
            } else strings.add("");
        }

        return new User(strings.get(0),strings.get(1),strings.get(2),strings.get(3),Role.USER);
    }

    @Override
    public User getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        return findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        Set<Role> roles = new HashSet<>();
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User with username " + username + " not found");
        } else
            System.out.println("SUCCESS");
        roles.add(user.getRole());
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), convertRole(roles));
    }

    private Collection<? extends GrantedAuthority> convertRole(Set<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toSet());
    }
}
