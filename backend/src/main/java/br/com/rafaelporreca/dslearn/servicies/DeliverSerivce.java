package br.com.rafaelporreca.dslearn.servicies;

import br.com.rafaelporreca.dslearn.dtos.DeliverRevisionDTO;
import br.com.rafaelporreca.dslearn.entities.Deliver;
import br.com.rafaelporreca.dslearn.observers.DeliverRevisionObserver;
import br.com.rafaelporreca.dslearn.repositories.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class DeliverSerivce {

    private DeliverRepository repository;

    @Autowired
    public DeliverSerivce(DeliverRepository repository) {
        this.repository = repository;
    }

    private Set<DeliverRevisionObserver>deliverRevisionObservers = new LinkedHashSet<>();

    @Transactional
    public void saveRevision(Long id, DeliverRevisionDTO dto){
        Deliver deliver = repository.getOne(id);
        deliver.setStatus(dto.getStatus());
        deliver.setFeedback(dto.getFeedback());
        deliver.setCorrectCount(dto.getCorrectCount());
        repository.save(deliver);
        for(DeliverRevisionObserver observer : deliverRevisionObservers){
            observer.onSaveRevision(deliver);
        }
    }

    public void subscribeDeliverRevisionObserver(DeliverRevisionObserver observer){
        deliverRevisionObservers.add(observer);
    }
}
