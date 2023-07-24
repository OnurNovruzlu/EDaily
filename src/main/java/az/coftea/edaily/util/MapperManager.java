package az.coftea.edaily.util;

import az.coftea.edaily.dto.*;
import az.coftea.edaily.model.*;
import az.coftea.edaily.repository.*;
import az.coftea.edaily.exception.ModelNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MapperManager implements MyMapper {

    private final SchoolRepository schoolRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final DailyRepository dailyRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public Teacher toTeacher(NewTeacher newTeacher) {
        Teacher teacher = new Teacher();
        teacher.setName(newTeacher.getName());
        teacher.setSurname(newTeacher.getSurname());
        teacher.setBirthday(newTeacher.getBirthday());
        teacher.setSchool(schoolRepository.findById(newTeacher.getSchoolId()).orElseThrow(() -> new ModelNotFoundException("School not found with id")));
        teacher.setRole(Role.valueOf(newTeacher.getRole()));
        teacher.setSubject(subjectRepository.findById(newTeacher.getSubjectId()).orElseThrow(() -> new ModelNotFoundException("Subject not found")));
        return teacher;
    }

    @Override
    public TeacherResponse fromTeacher(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacherResponse.getId());
        teacherResponse.setName(teacher.getName());
        teacherResponse.setSurname(teacher.getSurname());
        teacherResponse.setBirthday(teacher.getBirthday());
        teacherResponse.setSchoolName(teacher.getSchool().getName());
        teacherResponse.setCreatedAt(teacher.getCreatedAt());
        teacherResponse.setStatus(teacher.getStatus().name());
        teacherResponse.setRole(teacher.getRole().name());
        teacherResponse.setSubjectName(teacher.getSubject().getName());
        return teacherResponse;
    }

    @Override
    public Subject toSubject(NewSubject newSubject) {
        Subject subject = new Subject();
        subject.setName(newSubject.getName());
        subject.setSchool(schoolRepository.findById(newSubject.getSchoolId()).orElseThrow(() -> new ModelNotFoundException("School not found")));
        return subject;
    }

    @Override
    public SubjectResponse fromSubject(Subject subject) {
        SubjectResponse response = new SubjectResponse();
        response.setId(subject.getId());
        response.setName(subject.getName());
        response.setStatus(subject.getStatus().name());
        response.setCreatedAt(subject.getCreatedAt());
        response.setSchoolName(subject.getSchool().getName());
        response.setTeacherNames(subject.getTeachers().stream().map(Teacher::getName).collect(Collectors.toList()));
        return response;
    }

    @Override
    public School toSchool(NewSchool newSchool) {
        School school = new School();
        school.setName(newSchool.getName());
        school.setDescription(newSchool.getDescription());
        school.setLocation(newSchool.getLocation());
        return school;
    }

    @Override
    public SchoolResponse fromSchoolToAll(School school) {
        SchoolResponse response = new SchoolResponse();
        response.setId(school.getId());
        response.setName(school.getName());
        response.setLocation(school.getLocation());
        response.setStatus(school.getStatus().name());
        response.setDescription(school.getDescription());
        response.setCreatedAt(school.getCreatedAt());
        response.setTeacherNames(school.getTeachers().stream().map(Teacher::getName).collect(Collectors.toList()));
        response.setStudentNames(school.getStudents().stream().map(Student::getName).collect(Collectors.toList()));
        response.setSubjectNames(school.getSubjects().stream().map(Subject::getName).collect(Collectors.toList()));
        response.setDirector(fromTeacher(school.getTeachers().stream().filter(t-> t.getRole().equals(Role.DIRECTOR)).findFirst().orElseThrow(()->new ModelNotFoundException("Director not found"))));
        return response;
    }

    @Override
    public SchoolResponseS fromSchoolToSimple(School school) {
        SchoolResponseS response = new SchoolResponseS();
        response.setId(school.getId());
        response.setName(school.getName());
        response.setStatus(school.getStatus().name());
        response.setLocation(school.getLocation());
        response.setDescription(school.getDescription());
        response.setCreatedAt(school.getCreatedAt());
        return response;
    }

    @Override
    public Room toRoom(NewRoom newRoom) {
        Room room = new Room();
        room.setNumber(newRoom.getNumber());
        room.setSchool(schoolRepository.findById(newRoom.getSchoolId()).orElseThrow(() -> new ModelNotFoundException("School not found")));
        return room;
    }

    @Override
    public RoomResponse fromRoom(Room room) {
        RoomResponse roomResponse = new RoomResponse();
        roomResponse.setId(roomResponse.getId());
        roomResponse.setNumber(roomResponse.getNumber());
        roomResponse.setCreatedAt(room.getCreatedAt());
        roomResponse.setStatusName(room.getStatus().name());
        roomResponse.setSchoolName(room.getSchool().getName());
        return roomResponse;
    }

    @Override
    public DailyResponse fromDaily(Daily daily) {
        DailyResponse response = new DailyResponse();
        response.setId(daily.getId());
        response.setStatus(daily.getStatus().name());
        response.setCreatedAt(daily.getCreatedAt());
        response.setStudent(fromStudent(daily.getStudent()));
        response.setPoints(daily.getPoints().stream().map(Point::getPoint).collect(Collectors.toList()));
        return response;
    }

    @Override
    public Daily toDaily(NewDaily newDaily) {
        Daily daily = new Daily();
        daily.setStudent(studentRepository.findById(newDaily.getStudentId()).orElseThrow(()->new ModelNotFoundException("Student not found")));
        return daily;
    }

    @Override
    public PointResponse fromPoint(Point point) {
        PointResponse response = new PointResponse();
        response.setPoint(point.getPoint());
        response.setCreatedAt(point.getCreatedAt());
        response.setStatus(point.getStatus().name());
        response.setSubjectName(point.getSubject().getName());
        response.setTeacherName(point.getTeacher().getName());
        response.setDailyId(point.getDaily().getId());
        return response;
    }

    @Override
    public Point toPoint(NewPoint newPoint) {
        Point point = new Point();
        point.setPoint(newPoint.getPoint());
        point.setSubject(subjectRepository.findById(newPoint.getSubjectId()).orElseThrow(()->new ModelNotFoundException("Subject not found")));
        point.setDaily(dailyRepository.findById(newPoint.getDailyId()).orElseThrow(()->new ModelNotFoundException("Daily not found")));
        point.setTeacher(teacherRepository.findById(newPoint.getTeacherId()).orElseThrow(()-> new ModelNotFoundException("Teacher not found")));
        return point;
    }
}
