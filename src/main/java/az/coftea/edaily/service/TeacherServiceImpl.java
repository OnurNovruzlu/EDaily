package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewTeacher;
import az.coftea.edaily.dto.TeacherResponse;
import az.coftea.edaily.repository.TeacherRepository;
import az.coftea.edaily.util.MapperManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final MapperManager mapperManager;
    private final TeacherRepository teacherRepository;

    @Override
    public TeacherResponse getTeacher(int id) {

    }

    @Override
    public List<TeacherResponse> getAll() {
        return ;
    }

    @Override
    public TeacherResponse getDirector() {
        return null;
    }

    @Override
    public String insert(NewTeacher newTeacher) {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public String update(int id, NewTeacher newTeacher) {
        return null;
    }
}
