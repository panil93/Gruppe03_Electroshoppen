/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

/**
 *
 * @author Laura
 */
public class Medarbejder {

    private String fuldnavn;
    private String login;
    private String adgangskode;
    private String type;

    public Medarbejder(String fuldnavn, String login, String adgangskode, String type) {
        this.fuldnavn = fuldnavn;
        this.login = login;
        this.adgangskode = adgangskode;
        this.type = type;
    }

    public String getLogin() {
        return this.login;
    }

    public String getAdgangskode() {
        return this.adgangskode;
    }

}