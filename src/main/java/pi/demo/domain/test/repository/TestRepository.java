package pi.demo.domain.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pi.demo.domain.test.entity.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

}
