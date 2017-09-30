package landing.CFG2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyJourneysRepository extends JpaRepository<MyJourney, Long> {
	List<MyJourney> findByUser(User user);
}
