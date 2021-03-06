package br.com.rafaelporreca.dslearn.resources;

import br.com.rafaelporreca.dslearn.dtos.UserDTO;
import br.com.rafaelporreca.dslearn.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findbyId(@PathVariable Long id){
        UserDTO dto = userService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}
