package br.com.rafaelporreca.dslearn.servicies;

import br.com.rafaelporreca.dslearn.dtos.UserDTO;
import br.com.rafaelporreca.dslearn.entities.User;
import br.com.rafaelporreca.dslearn.repositories.UserRepository;
import br.com.rafaelporreca.dslearn.servicies.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);


    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userName);
        if(user == null){
            logger.error("User not found: " + userName);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("User found: " + userName);
        return user;
    }

    public UserDTO findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UserDTO(entity);
    }
}
