package br.com.rafaelporreca.dslearn.repositories;

import br.com.rafaelporreca.dslearn.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
}
