package br.com.rafaelporreca.dslearn.repositories;

import br.com.rafaelporreca.dslearn.entities.Enrollment;
import br.com.rafaelporreca.dslearn.entities.pk.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
