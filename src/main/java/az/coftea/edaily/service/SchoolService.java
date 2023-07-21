package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewSchool;
import az.coftea.edaily.dto.SchoolResponse;

import java.util.List;

public interface SchoolService {
    List<SchoolResponse> getAll();
    SchoolResponse getSchoolWithDirector();
    SchoolResponse getSchoolWithAllDetails();
    String insert(NewSchool newSchool);
    String update(int id , NewSchool newSchool);
    String delete(int id);

}
