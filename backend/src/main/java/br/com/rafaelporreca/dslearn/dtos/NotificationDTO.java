package br.com.rafaelporreca.dslearn.dtos;

import br.com.rafaelporreca.dslearn.entities.Notification;
import br.com.rafaelporreca.dslearn.entities.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.Instant;

public class NotificationDTO implements Serializable {

    private Long id;
    private String text;
    private Instant moment;
    private boolean read;
    private String route;
    private Long userId;

    public NotificationDTO() {
    }

    public NotificationDTO(Long id, String text, Instant moment, boolean read, String route, Long userId) {
        this.id = id;
        this.text = text;
        this.moment = moment;
        this.read = read;
        this.route = route;
        this.userId = userId;
    }

    public NotificationDTO(Notification entity) {
        id = entity.getId();
        text = entity.getText();
        moment = entity.getMoment();
        read = entity.isRead();
        route = entity.getRoute();
        userId = entity.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Instant getMoment() {
        return moment;
    }

    public boolean isRead() {
        return read;
    }

    public String getRoute() {
        return route;
    }

    public Long getUserId() {
        return userId;
    }
}
