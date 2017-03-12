/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slavko.baze2.procesnabavke.gui.forme.faktura.model;

import slavko.baze2.procesnabavke.gui.domen.Proizvod;
import slavko.baze2.procesnabavke.gui.domen.Faktura;
import slavko.baze2.procesnabavke.gui.domen.StavkaFakture;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Slavko
 */
public class StavkaFaktureTableModel extends AbstractTableModel {

    private Faktura faktura;
    private final String[] kolone = new String[]{"Rbr", "Proizvod", "J.M.", "KOL", "Jed. cena", "Neto vrednost", "PDV", "Pr. vrednost"};

    public StavkaFaktureTableModel(Faktura faktura) {
        this.faktura = faktura;
    }

    @Override
    public int getRowCount() {
        return faktura.getStavke().size();
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
        StavkaFakture stavka = faktura.getStavke().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stavka.getRedniBroj();
            case 1:
                return stavka.getProizvod().getNaziv();
            case 2:
                return null;
            case 3:
                return stavka.getKoličina();
            case 4:
                return stavka.getJediničnaCena();
            case 5:
                return Math.round((stavka.getJediničnaCena() * stavka.getKoličina())*1000.0)/1000.0;
            case 6:
                if (faktura.getKompletirana()) {
                    return stavka.getPdv();
                } else {
                    return "";
                }
            case 7:
                if (faktura.getKompletirana()) {
                    return stavka.getProdajnaVrednost();
                } else {
                    return "";
                }
            default:
                return "error";

        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(!faktura.getKompletirana() && columnIndex==3){
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       StavkaFakture stavka = faktura.getStavke().get(rowIndex);
       if(columnIndex==3){
           try {
               int količina = Integer.parseInt((String)aValue);
               if(količina>0){
                   stavka.setKoličina(količina); 
                   fireTableCellUpdated(rowIndex, 5);
               }               
           } catch (Exception e) {
           }
       }
    }
    
    
    
    
    

    public void dodajStavku(Proizvod proizvod, int količina) {
        for(StavkaFakture sf : faktura.getStavke()){
            if(sf.getProizvod().equals(proizvod)){
                sf.setKoličina(sf.getKoličina()+količina);
                fireTableDataChanged();
                return;
            }
        }
        
        StavkaFakture stavka = new StavkaFakture(faktura.getStavke().size() + 1, količina, null, 0d, 0d, proizvod);
        faktura.getStavke().add(stavka);
        fireTableDataChanged();
    }

    public void obrisiStavku(int red) {
        faktura.getStavke().remove(red);
        for (int i = red; i < faktura.getStavke().size(); i++) {
            faktura.getStavke().get(i).setRedniBroj(faktura.getStavke().get(i).getRedniBroj() - 1);
        }
        fireTableDataChanged();
    }

    public Faktura vratiFakturu() {
        return faktura;
    }
}
