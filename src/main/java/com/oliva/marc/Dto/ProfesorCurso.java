package com.oliva.marc.Dto;

import java.util.List;

import com.oliva.marc.model.entity.Course;
import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.entity.Teacher;

public class ProfesorCurso {

    private Teacher teacher;
    private List<Course> cursos;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Course> getCursos() {
        return cursos;
    }

    public void setCursos(List<Course> cursos) {
        this.cursos = cursos;
    }

}