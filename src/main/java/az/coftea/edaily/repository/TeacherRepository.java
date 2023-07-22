package az.coftea.edaily.repository;

import az.coftea.edaily.model.Role;
import az.coftea.edaily.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Optional<Teacher> findByRole(@NotNull(message = "role cannot be null") Role role);
}
