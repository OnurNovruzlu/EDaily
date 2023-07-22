package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewSubject;
import az.coftea.edaily.dto.SubjectResponse;

import java.util.List;

public interface SubjectService {
    List<SubjectResponse> getAll();
    SubjectResponse getSubject(int id);
    String insert(NewSubject newSubject);
    String delete(int id);
    String update(int id, NewSubject newSubject);
}
