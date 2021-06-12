package br.com.rafaelporreca.dslearn.servicies;

import br.com.rafaelporreca.dslearn.entities.User;
import br.com.rafaelporreca.dslearn.repositories.UserRepository;
import br.com.rafaelporreca.dslearn.servicies.exceptions.ForbiddenException;
import br.com.rafaelporreca.dslearn.servicies.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public User authenticated(){
        try {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(userName);
        }catch (Exception e){
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validateSelfOrAdmin(Long userId){
        User user = authenticated();
        if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denid");
        }
    }
}
