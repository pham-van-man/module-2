package study_case.util;

import study_case.model.Instructor;

public class CreateInstructor implements Create<Instructor> {
    @Override
    public Instructor getObject(String[] content) {
        return new Instructor(Integer.parseInt(content[0]), content[1], Integer.parseInt(content[2]), content[3], content[4], content[5]);
    }
}
