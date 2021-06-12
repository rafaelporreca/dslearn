package br.com.rafaelporreca.dslearn.repositories;

import br.com.rafaelporreca.dslearn.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {
}
