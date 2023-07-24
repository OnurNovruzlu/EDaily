package az.coftea.edaily.service;

import az.coftea.edaily.dto.DailyResponse;
import az.coftea.edaily.dto.NewDaily;
import az.coftea.edaily.exception.ModelNotFoundException;
import az.coftea.edaily.model.Daily;
import az.coftea.edaily.model.Status;
import az.coftea.edaily.repository.DailyRepository;
import az.coftea.edaily.repository.StudentRepository;
import az.coftea.edaily.util.MyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DailyServiceImpl implements DailyService {
    private final DailyRepository dailyRepository;
    private final StudentRepository studentRepository;
    private final MyMapper mapper;

    @Override
    public DailyResponse getDaily(int id) {
        return mapper.fromDaily(dailyRepository.findById(id).orElseThrow(()->new ModelNotFoundException("Daily not found")));
    }

    @Override
    public List<DailyResponse> getAll() {
        return dailyRepository.findAll().stream().map(mapper::fromDaily).collect(Collectors.toList());
    }
    @Transactional
    @Override
    public String insert(NewDaily newDaily) {
        dailyRepository.save(mapper.toDaily(newDaily));
        return "ok";
    }
    @Transactional
    @Override
    public String delete(int id) {
        Daily daily = dailyRepository.findById(id).orElseThrow(()->new ModelNotFoundException("Daily not found"));
        daily.setStatus(Status.DEACTIVE);
        dailyRepository.save(daily);
        return "ok";
    }
    @Transactional
    @Override
    public String update(int id, NewDaily newDaily) {
        Daily daily = dailyRepository.findById(id).orElseThrow(()->new ModelNotFoundException("Daily not found"));
        daily.setStudent(studentRepository.findById(newDaily.getStudentId()).orElseThrow(()->new ModelNotFoundException("Student not found")));
        dailyRepository.save(daily);
        return "ok";
    }
}
