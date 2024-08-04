package study_case.util;

import study_case.model.Student;

public class CreateStudent implements Create<Student> {
    @Override
    public Student getObject(String[] content) {
        return new Student(Integer.parseInt(content[0]), content[1], Integer.parseInt(content[2]), content[3], content[4], content[5]);
    }
}
