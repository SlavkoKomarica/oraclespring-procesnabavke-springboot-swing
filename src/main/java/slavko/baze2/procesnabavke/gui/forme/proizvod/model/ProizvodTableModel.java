/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slavko.baze2.procesnabavke.gui.forme.proizvod.model;

import slavko.baze2.procesnabavke.gui.domen.PoslovniPartner;
import slavko.baze2.procesnabavke.gui.domen.Proizvod;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Slavko
 */
public class ProizvodTableModel extends AbstractTableModel {

    private List<Proizvod> lp = new ArrayList<>();
    private final String[] kolone = new String[]{"Klas. broj", "Naziv", "Cena", "M.J.", "PDV stopa", "Stanje"};

    public ProizvodTableModel(List<Proizvod> lp) {
        this.lp = lp;
    }

    @Override
    public int getRowCount() {
        return lp.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proizvod proizvod = lp.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return proizvod.getKlasifikacioniBroj();
            case 1:
                return proizvod.getNaziv();
            case 2:
                return proizvod.getCenaBezPDVa() + " din";
            case 3:
                return proizvod.getMernaJedinica();
            case 4:
                if (proizvod.getPdvStopa() != null) {
                    return proizvod.getPdvStopa().getNaziv() + "(" + proizvod.getPdvStopa().getProcenat() + "%)";
                } else {
                    return "";
                }
            case 5:
                return proizvod.getStanje();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Proizvod getProizvod(int red) {
        return lp.get(red);
    }

    public void dodajProizvod(Proizvod proizvod) {
        lp.add(proizvod);
        fireTableDataChanged();
    }

    public void obrisiRed(int red) {
        lp.remove(red);
        fireTableDataChanged();
    }

    public List<Proizvod> vratiProizvode() {
        return lp;
    }

    public void postaviProizvode(List<Proizvod> lp) {
        this.lp = lp;
        fireTableDataChanged();
    }

}
