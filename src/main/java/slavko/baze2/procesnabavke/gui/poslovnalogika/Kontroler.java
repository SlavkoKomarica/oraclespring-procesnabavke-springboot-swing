/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slavko.baze2.procesnabavke.gui.poslovnalogika;

import slavko.baze2.procesnabavke.gui.domen.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Slavko
 */
public class Kontroler {

    private static Kontroler instance;
    private Map<String, Object> map;

    private Kontroler() {
        map = new HashMap<>();
    }

    public static Kontroler vratiInstancu() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public List<Proizvod> vratiProizvode() throws Exception {
        return null;
    }

    public void dodajProizvod(Proizvod p) throws Exception {

    }

    public void izmeniProizvod(Proizvod p) throws Exception {
    }

    public void obrisiProizvod(Proizvod p) throws Exception {
    }

    public List<Faktura> vratiFakture() throws Exception {
        return null;

    }

    public void dodajFakturu(Faktura f) throws Exception {
    }

    public void izmeniFakturu(Faktura f) throws Exception {
    }
    
    public void kompletirajFakturu(Faktura f) throws Exception{
    }

    public void obrisiFakturu(Faktura f) throws Exception {
    }

    public List<NačinPlaćanja> vratiNačinePlaćanja() throws Exception {
        return null;
    }

    public List<PoslovniPartner> vratiPoslovnePartnere() throws Exception {
        return null;
    }

    public List<PDVStopa> vratiListuPDVStopa() throws Exception {
        return null;
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void remove(String key) {
        map.remove(key);
    }

    public String generisiKlasBrojProizvoda() throws Exception {
        return null;
    }
    
     public String generisiBrojFakture() throws Exception {
         return null;
    }

    static String longToString(long num, int digits) {
        return null;
    }
    
    public Zaposleni pronadjiZaposlenog(String korisničkoIme, String šifra) throws Exception {
        return null;
    }
}
