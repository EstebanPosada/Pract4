package com.estebanposada.pract4;

/**
 * Created by usuario on 02/10/2015.
 */
public class Lista_bars {
    private int Idimage;
    private String bar;
    private String info3;

    public Lista_bars(int idimage, String bar, String info3) {
        this.bar = bar;
        Idimage = idimage;
        this.info3 = info3;
    }

    public String getBar() {
        return bar;
    }

    public int getIdimage() {
        return Idimage;
    }

    public String getInfo3() {
        return info3;
    }
}
