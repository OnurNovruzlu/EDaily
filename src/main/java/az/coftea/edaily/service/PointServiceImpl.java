package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewPoint;
import az.coftea.edaily.dto.PointResponse;
import az.coftea.edaily.exception.ModelNotFoundException;
import az.coftea.edaily.model.Point;
import az.coftea.edaily.model.Status;
import az.coftea.edaily.repository.PointRepository;
import az.coftea.edaily.util.MyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements  PointService{
    private final PointRepository pointRepository;
    private final MyMapper mapper;

    @Override
    public List<PointResponse> getAll() {
        return pointRepository.findAll().stream().map(mapper::fromPoint).collect(Collectors.toList());
    }
    @Transactional
    @Override
    public String insert(NewPoint newPoint) {
        pointRepository.save(mapper.toPoint(newPoint));
        return "ok";
    }
    @Transactional
    @Override
    public String delete(int id) {
        Point point = pointRepository.findById(id).orElseThrow(()->new ModelNotFoundException("Point not found"));
        point.setStatus(Status.DEACTIVE);
        pointRepository.save(point);
        return "ok";
    }
    @Transactional
    @Override
    public String update(int id, Integer newPoint) {
        Point point = pointRepository.findById(id).orElseThrow(()->new ModelNotFoundException("Point not found"));
        point.setPoint(newPoint);
        pointRepository.save(point);
        return "ok";
    }
}
