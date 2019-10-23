package com.wjwhs.dao;

public class ReflectionOfStudentAndCourse {
    private int id;
    private int studentId;
    private int courseId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "ReflectionOfStudentAndCourse{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}
