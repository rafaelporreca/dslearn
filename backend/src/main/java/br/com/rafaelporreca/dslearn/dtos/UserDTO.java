package br.com.rafaelporreca.dslearn.dtos;

import br.com.rafaelporreca.dslearn.entities.User;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class UserDTO implements Serializable {

    private Long id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
