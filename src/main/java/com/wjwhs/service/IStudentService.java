package com.wjwhs.service;

public interface IStudentService {
    /**
     * 根据courseId查询score
     */
    public int queryCourseScore(int courseId);

    /**
     * 根据studentId查询score
     * @param studentId
     * @return
     */
    public int queryStudentScore(int studentId);

    /**
     * 根据studentId更新score
     * @param studentId
     * @param studentScore
     * @param courseScore
     */
    public void updateStudentScore(int studentId, int studentScore, int courseScore);

    /**
     * 修改完后往映射表插入一行新记录
     * @param studentId
     * @param courseId
     */
    public void insertIntoStudentCourse(int studentId, int courseId);
}
