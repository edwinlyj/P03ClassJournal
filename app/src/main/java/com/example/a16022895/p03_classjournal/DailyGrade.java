package com.example.a16022895.p03_classjournal;

public class DailyGrade {
    private String week;
    private Character grade;

    public DailyGrade(String week, Character grade) {
        this.week = week;
        this.grade = grade;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public Character getGrade() {
        return grade;
    }

    public void setGrade(Character grade) {
        this.grade = grade;
    }
}
