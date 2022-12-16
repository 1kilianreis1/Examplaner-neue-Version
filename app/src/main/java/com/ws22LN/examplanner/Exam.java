package com.ws22LN.examplanner;

import java.io.Serializable;

class Exam implements Serializable
{
    String date;
    String time;
    String subject;
    String room;
    String comment;

    public String getDate(){return date;}
    public void setDate(String date){this.date=date;}

    public String getTime(){return time;}
    public void setTime(String time){this.time=time;}

    public String getSubject(){return subject;}
    public void setSubject(String subject){this.subject=subject;}

    public String getRoom(){return room;}
    public void setRoom(String room){this.room=room;}

    public String getComment(){return comment;}
    public void setComment(String comment){this.comment=comment;}
}
