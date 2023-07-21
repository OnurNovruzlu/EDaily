package az.coftea.edaily.service;

import java.util.List;

public interface RoomService {
    List<RoomResponse> getAll();
    RoomResponse getRoom(int id);
    RoomResponse getRoomByNumber(String number);
    String insert(NewRoom newRoom);
    String delete(int id);
    String update(int id, NewRoom newRoom);
}
