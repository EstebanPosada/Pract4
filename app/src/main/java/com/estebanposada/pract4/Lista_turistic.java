package com.estebanposada.pract4;

/**
 * Created by usuario on 03/10/2015.
 */
public class Lista_turistic {
    private int Idimagen;
    private String turi;
    private String info4;

    public Lista_turistic(int idimagen, String turi, String info4) {
        Idimagen = idimagen;
        this.info4 = info4;
        this.turi = turi;

    }

    public int getIdimagen() {
        return Idimagen;
    }

    public String getInfo4() {
        return info4;
    }

    public void setInfo4(String info4) {
        this.info4 = info4;
    }

    public String getTuri() {
        return turi;
    }

    public void setTuri(String turi) {
        this.turi = turi;
    }
}
