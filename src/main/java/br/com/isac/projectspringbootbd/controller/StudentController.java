package br.com.isac.projectspringbootbd.controller;

import br.com.isac.projectspringbootbd.entity.StudentEntity;
import br.com.isac.projectspringbootbd.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public StudentEntity studentSave(@RequestBody StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    @GetMapping
    public List<StudentEntity> studentList() {
        return studentRepository.findAll();
    }

    @PutMapping("/{id}")
    public StudentEntity studentUpdate(@PathVariable Integer id, @RequestBody StudentEntity studentEntity) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Estudante com id"+id+" não localizado!")
        );
        student.setName(studentEntity.getName());
        student.setAge(studentEntity.getAge());
        student.setStudentRegistration(studentEntity.getStudentRegistration());
        student.setInstitutionalEmail(studentEntity.getInstitutionalEmail());
        student.setClassGroup(studentEntity.getClassGroup());
        student.setPeriod(studentEntity.getPeriod());
        student.setPresentation(studentEntity.getPresentation());
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public String studentDelete(@PathVariable Integer id) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Estudante com id"+id+" não localizado!")
        );
        studentRepository.delete(student);
        return "Estudante: "+student.getName()+" excluído com sucesso!";
    }
}
