package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewSchool;
import az.coftea.edaily.dto.SchoolResponse;
import az.coftea.edaily.dto.SchoolResponseS;
import az.coftea.edaily.exception.ModelNotFoundException;
import az.coftea.edaily.model.School;
import az.coftea.edaily.model.Status;
import az.coftea.edaily.repository.SchoolRepository;
import az.coftea.edaily.util.MyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;
    private final MyMapper mapper;

    @Override
    public List<SchoolResponseS> getAll() {
        return schoolRepository.findAll().stream().map(mapper::fromSchoolToSimple).collect(Collectors.toList());
    }

    @Override
    public SchoolResponse getSchoolWithAllData(int id) {
        return mapper.fromSchoolToAll(schoolRepository.findById(id).orElseThrow(()->new ModelNotFoundException("School not found")));
    }

    @Override
    public SchoolResponseS getById(int id) {
        return mapper.fromSchoolToSimple(schoolRepository.findById(id).orElseThrow(()->new ModelNotFoundException("School not found")));
    }

    @Override
    public String insert(NewSchool newSchool) {
        schoolRepository.save(mapper.toSchool(newSchool));
        return "ok";
    }

    @Override
    public String update(int id, NewSchool newSchool) {
        School school = schoolRepository.findById(id).orElseThrow(()->new ModelNotFoundException("School not found"));
        school.setName(newSchool.getName());
        school.setLocation(newSchool.getLocation());
        school.setDescription(newSchool.getDescription());
        schoolRepository.save(school);
        return "ok";
    }

    @Override
    public String delete(int id) {
        School school = schoolRepository.findById(id).orElseThrow(()->new ModelNotFoundException("School not found"));
        school.setStatus(Status.DEACTIVE);
        schoolRepository.save(school);
        return "ok";
    }
}
