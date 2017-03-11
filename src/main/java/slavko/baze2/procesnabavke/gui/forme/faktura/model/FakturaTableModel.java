/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slavko.baze2.procesnabavke.gui.forme.faktura.model;

import slavko.baze2.procesnabavke.gui.domen.Faktura;
import slavko.baze2.procesnabavke.gui.domen.Proizvod;
import slavko.baze2.procesnabavke.gui.domen.StavkaFakture;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Slavko
 */
public class FakturaTableModel extends AbstractTableModel {

    private List<Faktura> lf;
    private final String[] kolone = new String[]{"Broj", "Partner", "Datum fak.", "Rok", "Vrednost", "Status"};
    private final DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    public FakturaTableModel(List<Faktura> lf) {
        this.lf = lf;
    }

    @Override
    public int getRowCount() {
        return lf.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Faktura faktura = lf.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return faktura.getBrojFakture();
            case 1:
                return faktura.getPoslovniPartner();
            case 2:
                if (faktura.getDatumFakturisanja() == null) {
                    return "";
                }
                return df.format(faktura.getDatumFakturisanja());
            case 3:
                if (faktura.getRok() == null) {
                    return "";
                }
                return df.format(faktura.getRok());
            case 4:
                if (faktura.getKompletirana()) {
                    return faktura.getUkupanIznos();
                }else{
                    Double netoIznos = 0.0;
                    for(StavkaFakture stavkaFakture: faktura.getStavke()){
                        netoIznos+=stavkaFakture.getJediničnaCena()*stavkaFakture.getKoličina();
                    }
                    return Math.round(netoIznos*1000.0)/1000.0;
                }
            case 5:
                return faktura.getKompletirana() ? "KOMPLETIRANA" : "DRAFT";
            default:
                return "GREŠKA";

        }
    }

    public void dodajFakturu(Faktura faktura) {
        lf.add(faktura);
        fireTableDataChanged();
    }

    public void obrišiFakturu(int red) {
        lf.remove(red);
        fireTableDataChanged();
    }

    public Faktura vratiFakturu(int red) {
        return lf.get(red);
    }

    public List<Faktura> vratiFakture() {
        return lf;
    }

    public void postaviFakture(List<Faktura> lf) {
        this.lf = lf;
        fireTableDataChanged();
    }
}
