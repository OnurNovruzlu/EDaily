package az.coftea.edaily.controller;

import az.coftea.edaily.dto.NewRoom;
import az.coftea.edaily.dto.RoomResponse;
import az.coftea.edaily.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/all")
    List<RoomResponse> getAll() {
        return roomService.getAll();
    }

    @GetMapping("/get/{id}")
    RoomResponse getRoom(@PathVariable int id) {
        return roomService.getRoom(id);
    }

    @GetMapping("/{number}")
    RoomResponse getRoomByNumber(@PathVariable String number) {
        return roomService.getRoomByNumber(number);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/insert")
    String insert(NewRoom newRoom) {
        return roomService.insert(newRoom);
    }

    @DeleteMapping("/{id}")
    String delete(@PathVariable int id) {
        return roomService.delete(id);
    }

    @PutMapping("/{id}")
    String update(@PathVariable int id, @RequestBody NewRoom newRoom) {
        return roomService.update(id, newRoom);
    }

}
