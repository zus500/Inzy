package inz.Class;

import javax.persistence.*;

@Entity
public class Pracownik {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer idd;

    @Column
    private String imie;

    @Column
    private String nazwisko;

    @Column
    private String login;

    @Column
    private String haslo;



    public Integer getId() {
        return idd;
    }

    public void setId(Integer id) {
        this.idd = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Pracownik() {
    }

    @Override
    public String toString() {
        return imie + " " +nazwisko ;
    }

    public Integer getIdd() {
        return idd;
    }

    public void setIdd(Integer idd) {
        this.idd = idd;
    }
}
