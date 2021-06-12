package br.com.rafaelporreca.dslearn.repositories;

import br.com.rafaelporreca.dslearn.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section,Long> {
}
