/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;

/**
 *
 * @author Long Nguyen
 */
public class MusicCD implements Serializable{
    private String code;
    private String title;
    private String artist;
    private double price;

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getPrice() {
        return price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MusicCD(String code, String title, String artist, double price) {
        this.code = code;
        this.title = title;
        this.artist = artist;
        this.price = price;
    }
    
    
}
