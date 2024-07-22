package com.example.hasta_yatak_randevu;

import java.io.Serializable;

public class Hasta implements Serializable {
    private String isim;
    private String soyisim;
    private int yas;
    private int kimlikNumarasi;

    public Hasta(String isim, String soyisim, int yas, int kimlikNumarasi) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.yas = yas;
        this.kimlikNumarasi = kimlikNumarasi;
    }

    public Hasta() {
    }

    // Getters and Setters

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        if (yas >= 0) {
            this.yas = yas;
        } else {
            System.out.println("Invalid age: Age cannot be negative.");
        }
    }

    public int getKimlikNumarasi() {
        return kimlikNumarasi;
    }

    public void setKimlikNumarasi(int kimlikNumarasi) {
        // Add validation for identification number format if needed
        this.kimlikNumarasi = kimlikNumarasi;
    }

    public void bilgileriGoster() {
        System.out.println("Hasta bilgileri aşağıdaki gibidir\n" +
                "\nHasta ismi: " + this.isim +
                "\nHasta Soyismi: " + this.soyisim +
                "\nHasta yaş: " + this.yas +
                "\nHasta Tc no: " + this.kimlikNumarasi);
    }

    @Override
    public String toString() {
        return "Hasta{" +
                "isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                ", yas=" + yas +
                ", kimlikNumarasi=" + kimlikNumarasi +
                '}';
    }
}
