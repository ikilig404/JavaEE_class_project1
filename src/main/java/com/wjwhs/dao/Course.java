package com.wjwhs.dao;

import java.io.Serializable;

public class Course implements Serializable {
    private int id;
    private int name;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name=" + name +
                ", score=" + score +
                '}';
    }
}
