package com.estebanposada.pract4;

/**
 * Created by usuario on 01/10/2015.
 */
public class Lista_menu {
    private int Idimage;
    private String menu;
    private String info;

    public Lista_menu (int idimage, String menu, String info) {
        Idimage = idimage;
        this.menu = menu;
        this.info = info;
    }



    public int getIdimage() {
        return Idimage;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
