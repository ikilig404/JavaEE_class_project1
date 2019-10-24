package com.wjwhs.service.impl;

import com.wjwhs.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Component
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int queryCourseScore(int courseId) {
        String sql = "select score from course where id=?";
        int score = jdbcTemplate.queryForObject(sql, Integer.class, courseId);
        return score;
    }

    @Override
    public int queryStudentScore(int studentId) {
        String sql = "select score from student where id=?";
        int score = jdbcTemplate.queryForObject(sql, Integer.class, studentId);
        return score;
    }

    @Override
    public void updateStudentScore(int studentId, int studentScore, int courseScore) {
        // 当学生积分不够时，制作一个异常，引起异常通知
        if (studentScore < courseScore) {
            int exp = 1/0;
        }
        String sql = "update student set score=? where id=?";
        jdbcTemplate.update(sql, studentScore - courseScore, studentId);
    }

    @Override
    public void insertIntoStudentCourse(int studentId, int courseId) {
        String sql = "insert into student_course(course_id, student_id) values(?,?)";
        jdbcTemplate.update(sql, courseId, studentId);
    }
}
