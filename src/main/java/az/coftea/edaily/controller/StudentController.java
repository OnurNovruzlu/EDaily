package az.coftea.edaily.controller;

import az.coftea.edaily.dto.NewStudent;
import az.coftea.edaily.dto.StudentResponse;
import az.coftea.edaily.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/all")
    public List<StudentResponse> getAll() {
        return studentService.getAll();
    }

    @GetMapping("get/{id}")
    public StudentResponse getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/login")
    public StudentResponse login(@RequestParam String email, @RequestParam String password) {
        return studentService.login(email, password);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/insert")
    public String insert(@RequestBody NewStudent newStudent) {
        return studentService.insert(newStudent);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return studentService.delete(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody NewStudent newStudent) {
        return studentService.update(id, newStudent);
    }

}
