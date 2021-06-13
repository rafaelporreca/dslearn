package br.com.rafaelporreca.dslearn.servicies;

import br.com.rafaelporreca.dslearn.dtos.NotificationDTO;
import br.com.rafaelporreca.dslearn.entities.Notification;
import br.com.rafaelporreca.dslearn.entities.User;
import br.com.rafaelporreca.dslearn.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private NotificationRepository repository;
    private AuthService authService;

    @Autowired
    public NotificationService(NotificationRepository repository, AuthService authService) {
        this.repository = repository;
        this.authService = authService;
    }

    public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pageable){
        User user = authService.authenticated();
        Page<Notification> page = repository.find(user,unreadOnly,pageable);
        return page.map(obj -> new NotificationDTO(obj));
    }
}
