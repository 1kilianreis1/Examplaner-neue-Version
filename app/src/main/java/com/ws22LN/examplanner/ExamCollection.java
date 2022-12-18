package com.ws22LN.examplanner;

import androidx.collection.CircularArray;

import java.util.ArrayList;
import java.util.List;

public class ExamCollection
{
    public static List<Exam> allExams;
    static
    {
        allExams=new ArrayList<>();
        Exam englisch= new Exam();
        englisch.setDate("01/01/2023");
        englisch.setTime("13:37");
        englisch.setRoom("E420");
        englisch.setSubject("Englisch");
        englisch.setComment("DAS IST EIN SEHR LANGER DUMMER KOMMENTAR UM DAS LAYOUT ZU ZERSTÖREN");
        allExams.add(englisch);

       for (int i= 0; i<40; i++)
        {
            Exam mathe = new Exam();
            mathe.setDate("01/01/2023");
            mathe.setTime("13:37");
            mathe.setSubject("Mathe");
            mathe.setRoom("I420");
            mathe.setComment("FUCK");
            allExams.add(mathe);
        }
    }
}
