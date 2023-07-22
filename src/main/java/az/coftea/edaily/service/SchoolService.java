package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewSchool;
import az.coftea.edaily.dto.SchoolResponse;
import az.coftea.edaily.dto.SchoolResponseS;

import java.util.List;

public interface SchoolService {
    List<SchoolResponseS> getAll();
    SchoolResponse getSchoolWithAllData(int id);
    SchoolResponseS getById(int id);
    String insert(NewSchool newSchool);
    String update(int id , NewSchool newSchool);
    String delete(int id);

}
