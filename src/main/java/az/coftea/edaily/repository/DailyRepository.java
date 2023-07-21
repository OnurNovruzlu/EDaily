package az.coftea.edaily.repository;

import az.coftea.edaily.model.Daily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyRepository extends JpaRepository<Daily,Integer> {
}
