package br.com.rafaelporreca.dslearn.dtos;

import br.com.rafaelporreca.dslearn.entities.enums.DeliverStatus;

import java.io.Serializable;

public class DeliverRevisionDTO implements Serializable {

    private DeliverStatus status;
    private String feedback;
    private Integer correctCount;

    public DeliverRevisionDTO() {
    }

    public DeliverRevisionDTO(DeliverStatus status, String feedback, Integer correctCount) {
        this.status = status;
        this.feedback = feedback;
        this.correctCount = correctCount;
    }

    public DeliverStatus getStatus() {
        return status;
    }

    public String getFeedback() {
        return feedback;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }
}
