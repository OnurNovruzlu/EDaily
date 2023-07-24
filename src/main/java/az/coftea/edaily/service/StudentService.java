package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewStudent;
import az.coftea.edaily.dto.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getAll();
    StudentResponse getStudent(int id);
    StudentResponse login(String email,String password);
    String insert(NewStudent newStudent);
    String delete(int id);
    String update(int id, NewStudent newStudent);
}
