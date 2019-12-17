package com.example.demo.Class;

import javax.persistence.*;

@Entity
public class Sprawy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String numer_sprawy;

    @Column
    private String dane_poszkodowanego;

    @Column
    private String dane_sprawcy;

    @Column
    private String data_rozpoczecia;

    @Column
    private String dane_zakonczenia;

    @Column
    private String rodzaj_szkody;

    @Column
    private String opiekun;

    @Column
    private String klient;

    @Column
    private String opis;


    public String getRodzaj_szkody() {
        return rodzaj_szkody;
    }

    public void setRodzaj_szkody(String rodzaj_szkody) {
        this.rodzaj_szkody = rodzaj_szkody;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumer_sprawy() {
        return numer_sprawy;
    }

    public void setNumer_sprawy(String numer_sprawy) {
        this.numer_sprawy = numer_sprawy;
    }

    public String getDane_poszkodowanego() {
        return dane_poszkodowanego;
    }

    public void setDane_poszkodowanego(String dane_poszkodowanego) {
        this.dane_poszkodowanego = dane_poszkodowanego;
    }

    public String getDane_sprawcy() {
        return dane_sprawcy;
    }

    public void setDane_sprawcy(String dane_sprawcy) {
        this.dane_sprawcy = dane_sprawcy;
    }

    public String getData_rozpoczecia() {
        return data_rozpoczecia;
    }

    public void setData_rozpoczecia(String data_rozpoczecia) {
        this.data_rozpoczecia = data_rozpoczecia;
    }

    public String getDane_zakonczenia() {
        return dane_zakonczenia;
    }

    public void setDane_zakonczenia(String dane_zakonczenia) {
        this.dane_zakonczenia = dane_zakonczenia;
    }

    public String getOpiekun() {
        return opiekun;
    }

    public void setOpiekun(String opiekun) {
        this.opiekun = opiekun;
    }

    public String getKlient() {
        return klient;
    }

    public void setKlient(String klient) {
        this.klient = klient;
    }

    @Override
    public String toString() {
        return "Sprawy{" +
                "id=" + id +
                ", numer_sprawy='" + numer_sprawy + '\'' +
                ", dane_poszkodowanego='" + dane_poszkodowanego + '\'' +
                ", dane_sprawcy='" + dane_sprawcy + '\'' +
                ", data_rozpoczecia='" + data_rozpoczecia + '\'' +
                ", dane_zakonczenia='" + dane_zakonczenia + '\'' +
                ", rodzaj_szkody='" + rodzaj_szkody + '\'' +
                ", opiekun='" + opiekun + '\'' +
                ", klient='" + klient + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
