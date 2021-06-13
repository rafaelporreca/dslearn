package br.com.rafaelporreca.dslearn.servicies;

import br.com.rafaelporreca.dslearn.dtos.NotificationDTO;
import br.com.rafaelporreca.dslearn.entities.Deliver;
import br.com.rafaelporreca.dslearn.entities.Notification;
import br.com.rafaelporreca.dslearn.entities.User;
import br.com.rafaelporreca.dslearn.observers.DeliverRevisionObserver;
import br.com.rafaelporreca.dslearn.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Service
public class NotificationService implements DeliverRevisionObserver {

    private NotificationRepository repository;
    private AuthService authService;
    private DeliverSerivce deliverSerivce;

    @Autowired
    public NotificationService(NotificationRepository repository, AuthService authService, DeliverSerivce deliverSerivce) {
        this.repository = repository;
        this.authService = authService;
        this.deliverSerivce = deliverSerivce;
    }

    @PostConstruct
    private void Initialize(){
        deliverSerivce.subscribeDeliverRevisionObserver(this);
    }

    @Transactional(readOnly = true)
    public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pageable){
        User user = authService.authenticated();
        Page<Notification> page = repository.find(user,unreadOnly,pageable);
        return page.map(obj -> new NotificationDTO(obj));
    }

    @Transactional
    public void saveDeliverNotification(Deliver deliver){
        Long sectionId = deliver.getLesson().getSection().getId();
        Long resourceId = deliver.getLesson().getSection().getResource().getId();
        Long offerId = deliver.getLesson().getSection().getResource().getOffer().getId();

        String route = "/offers/"+offerId+"/resources/"+resourceId+"/sections/"+sectionId;
        String text = deliver.getFeedback();
        Instant moment = Instant.now();

        User user = deliver.getEnrollment().getStudent();

        Notification notification = new Notification(null,text,moment,false,route,user);
        repository.save(notification);
    }

    @Override
    public void onSaveRevision(Deliver deliver) {
        saveDeliverNotification(deliver);
    }
}
