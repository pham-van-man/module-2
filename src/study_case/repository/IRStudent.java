package study_case.repository;

import study_case.model.Member;
import study_case.model.Student;

import java.util.List;

public interface IRStudent {
    List<Member> findAllStudents();
}
