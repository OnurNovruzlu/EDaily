package az.coftea.edaily.service;

import java.util.List;

public interface DailyService {
    DailyResponse getDaily(int id);
    List<DailyResponse> getAll();
    String insert(NewDaily newDaily);
    String delete(int id);
    String update(int id, NewDaily newDaily);
}
