package br.com.rafaelporreca.dslearn.servicies;

import br.com.rafaelporreca.dslearn.dtos.DeliverRevisionDTO;
import br.com.rafaelporreca.dslearn.entities.Deliver;
import br.com.rafaelporreca.dslearn.repositories.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliverSerivce {

    private DeliverRepository repository;

    @Autowired
    public DeliverSerivce(DeliverRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void saveRevision(Long id, DeliverRevisionDTO dto){
        Deliver obj = repository.getOne(id);
        obj.setStatus(dto.getStatus());
        obj.setFeedback(dto.getFeedback());
        obj.setCorrectCount(dto.getCorrectCount());
        repository.save(obj);
    }
}
