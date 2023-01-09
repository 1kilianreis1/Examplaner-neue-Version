package com.example.letzte.neue.Version.Demo.Planer.Modal;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name ="exams") // Name der Tabelle
public class Exam implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String text;
    private String room;
    private String subject;

    //getter und setter Methoden
    public void setRoom (String room)
    {this.room=room;}
    public String getRoom(){
        return this.room;
    }


    public void setText(String text)
    {
        this.text =text;
    }
    public String getText()
    {
        return this.text;
    }


    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    public String getSubject()
    {
        return this.subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return id == exam.id && Objects.equals(text, exam.text) && Objects.equals(room, exam.room) && Objects.equals(subject, exam.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, room, subject);
    }
}
