package inz.Class;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Polisa {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;


    @Column
    private  String numer_polisy;

    @NotEmpty
    @Column
    private  String ubezpieczyciel;

    @Column
    private  String data_poczatku;

    @Column
    private  String data_konca;

    @Column
    private String skladka;

    @Column
    private String przedmiot_ubepizeczenia;

    @Column
    private String opis;

    @ManyToOne
    Klient klient;

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumer_polisy() {
        return numer_polisy;
    }

    public void setNumer_polisy(String numer_polisy) {
        this.numer_polisy = numer_polisy;
    }

    public String getUbezpieczyciel() {
        return ubezpieczyciel;
    }

    public void setUbezpieczyciel(String ubezpieczyciel) {
        this.ubezpieczyciel = ubezpieczyciel;
    }

    public String getData_poczatku() {
        return data_poczatku;
    }

    public void setData_poczatku(String data_poczatku) {
        this.data_poczatku = data_poczatku;
    }

    public String getData_konca() {
        return data_konca;
    }

    public void setData_konca(String data_konca) {
        this.data_konca = data_konca;
    }

    public String getSkladka() {
        return skladka;
    }

    public void setSkladka(String skladka) {
        this.skladka = skladka;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getPrzedmiot_ubepizeczenia() {
        return przedmiot_ubepizeczenia;
    }

    public void setPrzedmiot_ubepizeczenia(String przedmiot_ubepizeczenia) {
        this.przedmiot_ubepizeczenia = przedmiot_ubepizeczenia;
    }

    public Polisa() {
    }
}
