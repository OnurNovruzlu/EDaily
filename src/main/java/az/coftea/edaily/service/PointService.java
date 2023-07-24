package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewPoint;
import az.coftea.edaily.dto.PointResponse;

import java.util.List;

public interface PointService {
    List<PointResponse> getAll();
    String insert(NewPoint newPoint);
    String delete(int id);
    String update(int id, Integer point);
}
