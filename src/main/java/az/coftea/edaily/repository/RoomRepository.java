package az.coftea.edaily.repository;

import az.coftea.edaily.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Optional<Room> findByNumber(String number);
}
