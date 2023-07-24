package az.coftea.edaily.service;

import az.coftea.edaily.dto.NewRoom;
import az.coftea.edaily.dto.RoomResponse;
import az.coftea.edaily.exception.ModelNotFoundException;
import az.coftea.edaily.model.Room;
import az.coftea.edaily.model.Status;
import az.coftea.edaily.repository.RoomRepository;
import az.coftea.edaily.repository.SchoolRepository;
import az.coftea.edaily.util.MapperManager;
import az.coftea.edaily.util.MyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final SchoolRepository schoolRepository;
    private final RoomRepository roomRepository;
    private final MyMapper mapper;

    @Override
    public List<RoomResponse> getAll() {
        return roomRepository.findAll().stream().map(mapper::fromRoom).collect(Collectors.toList());
    }

    @Override
    public RoomResponse getRoom(int id) {
        return mapper.fromRoom(roomRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Room not found")));
    }

    @Override
    public RoomResponse getRoomByNumber(String number) {
        return mapper.fromRoom(roomRepository.findByNumber(number).orElseThrow(() -> new ModelNotFoundException("Room not found")));
    }

    @Transactional
    @Override
    public String insert(NewRoom newRoom) {
        roomRepository.save(mapper.toRoom(newRoom));
        return "ok";
    }

    @Transactional
    @Override
    public String delete(int id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Room not found"));
        room.setStatus(Status.DEACTIVE);
        roomRepository.save(room);
        return "ok";
    }

    @Transactional
    @Override
    public String update(int id, NewRoom newRoom) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Room not found"));
        room.setNumber(newRoom.getNumber());
        room.setSchool(schoolRepository.findById(newRoom.getSchoolId()).orElseThrow(() -> new ModelNotFoundException("School not found")));
        roomRepository.save(room);
        return "ok";
    }
}
