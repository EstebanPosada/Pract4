package com.estebanposada.pract4;

/**
 * Created by usuario on 02/10/2015.
 */
public class Lista_hotel {
    private int Idimage;
    private String hotel;
    private String info2;

    public Lista_hotel (int idimage, String hotel, String info2) {
        Idimage = idimage;
        this.hotel = hotel;
        this.info2 = info2;
    }

    public int getIdimage() {
        return Idimage;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }
}
