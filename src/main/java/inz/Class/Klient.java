package inz.Class;

import javax.persistence.*;
import java.util.List;

@Entity
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    private String nazwa;
    @Column
    private  String pesel;
    @Column
    private  String nip;
    @Column
    private  String numer_telefonu;
    @Column
    private  String miasto;
    @Column
    private  String ulica;
    @Column
    private  String kod_pocztowy;
    @Column
    private  String nr_domu_mieszkania;
    @Column
    private  String e_mail;
    @OneToMany
    private List<Polisa> polisas;



    @ManyToOne
    Pracownik pracownik;


    public List<Polisa> getPolisas() {
        return polisas;
    }

    public void setPolisas(List<Polisa> polisas) {
        this.polisas = polisas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getNr_domu_mieszkania() {
        return nr_domu_mieszkania;
    }

    public void setNr_domu_mieszkania(String nr_domu_mieszkania) {
        this.nr_domu_mieszkania = nr_domu_mieszkania;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Klient() {
    }

    @Override
    public String toString() {
        return nazwa;
    }

}
