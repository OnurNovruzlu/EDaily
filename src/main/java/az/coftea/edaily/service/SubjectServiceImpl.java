package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewSubject;
import az.coftea.edaily.dto.SubjectResponse;
import az.coftea.edaily.exception.ModelNotFoundException;
import az.coftea.edaily.model.Status;
import az.coftea.edaily.model.Subject;
import az.coftea.edaily.repository.SchoolRepository;
import az.coftea.edaily.repository.SubjectRepository;
import az.coftea.edaily.util.MyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService{
    private final SubjectRepository subjectRepository;
    private final SchoolRepository schoolRepository;
    private final MyMapper mapper;

    @Override
    public List<SubjectResponse> getAll() {
        return subjectRepository.findAll().stream().map(mapper::fromSubject).collect(Collectors.toList());
    }

    @Override
    public SubjectResponse getSubject(int id) {
        return mapper.fromSubject(subjectRepository.findById(id).orElseThrow(()->new ModelNotFoundException("subject not found")));
    }

    @Override
    @Transactional
    public String insert(NewSubject newSubject) {
        subjectRepository.save(mapper.toSubject(newSubject));
        return "ok";
    }

    @Override
    @Transactional
    public String delete(int id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(()->new ModelNotFoundException("subject not found"));
        subject.setStatus(Status.DEACTIVE);
        subjectRepository.save(subject);
        return "ok";
    }

    @Override
    @Transactional
    public String update(int id, NewSubject newSubject) {
        Subject subject = subjectRepository.findById(id).orElseThrow(()->new ModelNotFoundException("subject not found"));
        subject.setName(newSubject.getName());
        subject.setSchool(schoolRepository.findById(newSubject.getSchoolId()).orElseThrow(()->new ModelNotFoundException("school not found")));
        subjectRepository.save(subject);
        return "ok";
    }
}
