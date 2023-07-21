package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewSchool;
import az.coftea.edaily.dto.SchoolResponse;

public interface SchoolService {
    SchoolResponse getSchoolWithDirector();
    SchoolResponse getSchoolWithAllDetails();
    String insert(NewSchool newSchool);
    String update(int id , NewSchool newSchool);
    String delete(int id);

}
