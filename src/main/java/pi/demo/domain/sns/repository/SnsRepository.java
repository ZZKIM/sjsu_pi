package pi.demo.domain.sns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pi.demo.domain.sns.entity.Sns;

public interface SnsRepository extends JpaRepository<Sns, Long> {
}
