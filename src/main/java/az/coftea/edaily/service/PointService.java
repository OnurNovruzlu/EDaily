package az.coftea.edaily.service;

import java.util.List;

public interface PointService {
    List<PointResponse> getAll();
    PointResponse getByTimeInterval(String startDate, String endOfDate);
    PointResponse getBySubject(int id);
}
