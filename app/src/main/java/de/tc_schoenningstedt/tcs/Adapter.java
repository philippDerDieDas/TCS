package de.tc_schoenningstedt.tcs;


public class Adapter {
    private String name, telefon, email;

    public Adapter() {
    }

    public Adapter(String name, String telefon, String email) {
        this.name = name;
        this.telefon = telefon;
        this.email = email;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String name) {
        this.name = name;
    }

    public String getYear() {
        return email;
    }

    public void setYear(String email) {
        this.email = email;
    }

    public String getGenre() {
        return telefon;
    }

    public void setGenre(String telefon) {
        this.telefon = telefon;
    }
}