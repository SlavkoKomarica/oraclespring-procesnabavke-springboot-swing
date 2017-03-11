/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slavko.baze2.procesnabavke.gui.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Slavko
 */
public class Util {

    private Map<String, Object> map;
    private static Util instance;

    private Util() {
        map = new HashMap<>();
    }

    public static Util vratiInstancu() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public void postavi(String key, Object value) {
        map.put(key, value);
    }

    public Object vrati(String key) {
        return map.get(key);
    }

    public void obriši(String key) {
        map.remove(key);
    }

}
