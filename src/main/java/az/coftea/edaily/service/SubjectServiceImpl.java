package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewSubject;
import az.coftea.edaily.dto.SubjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService{
    @Override
    public List<SubjectResponse> getAll() {
        return null;
    }

    @Override
    public SubjectResponse getSubject(int id) {
        return null;
    }

    @Override
    public String insert(NewSubject newSubject) {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public String update(int id, NewSubject newSubject) {
        return null;
    }
}
