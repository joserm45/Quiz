package com.example.joserm45.quiz;

public class PreguntaTest {
    private String text;
    private String[] respostes;
    private int correcta;

    public PreguntaTest(String text, String[] respostes, int correcta) {
        this.text = text;
        this.respostes = respostes;
        this.correcta = correcta;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getRespostes() {
        return respostes;
    }

    public void setRespostes(String[] respostes) {
        this.respostes = respostes;
    }

    public int getCorrecta() {
        return correcta;
    }

    public void setCorrecta(int correcta) {
        this.correcta = correcta;
    }
}
