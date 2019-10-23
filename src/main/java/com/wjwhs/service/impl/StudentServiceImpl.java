package com.wjwhs.service.impl;

import com.wjwhs.dao.Student;
import com.wjwhs.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentServiceImpl implements IStudentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Student student;

    @Override
    public void selectCourse(int courseId) {
        String sql = "select score from course where id=?";
        int score = jdbcTemplate.queryForObject(sql, Integer.class, courseId);
        int finalScore = student.getScore() - score;
        String sql1 = "update student set score=? where id=?";
        jdbcTemplate.update(sql1, finalScore, student.getId());
        String sql2 = "insert into student_course(course_id, student_id) values(?,?)";
        jdbcTemplate.update(sql2, courseId, student.getId());
    }


}
