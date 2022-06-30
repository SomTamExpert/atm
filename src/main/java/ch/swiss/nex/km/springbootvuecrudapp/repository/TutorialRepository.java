package ch.swiss.nex.km.springbootvuecrudapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.swiss.nex.km.springbootvuecrudapp.model.Tutorial;

/**
 * interface TutorialRepository that interacts with Tutorials from database
 * 
 * @author marco karof
 * @version 31.01.2022
 * 
 */

// JpaRepository gives access to crud methods
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

  // finds tutorials by published
  List<Tutorial> findByPublished(boolean published);

  // finds tutorials by title
  List<Tutorial> findByTitleContaining(String title);

}
