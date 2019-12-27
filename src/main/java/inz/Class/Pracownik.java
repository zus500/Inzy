package inz.Class;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Transient;
@Entity
public class Pracownik {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer idd;
    @Column
    @NotEmpty(message = "Imię nie może być puste")
    private String imie;
    @Column
    @NotEmpty(message = "Nazwisko nie może być puste")
    private String nazwisko;
    @Column
    @Transient
    @Length(min = 5, message = "Hasło musi mieć więcej niż 5 znaków")
    @NotEmpty(message = "Hasło nie może być puste")
    private String haslo;
    @Column
    @NotEmpty(message = "Email nie może być pusty")
    @Email(message = "Musisz podać email")
    private String email;

    @Column
    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @ManyToMany
    @JoinTable
    private Set<Role> roles;

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

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Pracownik() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
