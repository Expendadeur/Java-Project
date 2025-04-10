/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcp.CONTROLLER;

import gcp.MODELES.Automobile;
import gcp.MODELES.Compagnie;
import gcp.MODELES.Route;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ISSA 2025
 */
public class CustomTableModel extends AbstractTableModel {
 private List<Object> records;
    private String[] columnNames;

    public CustomTableModel(List<Object> records, String table) {
        this.records = records;
        if (table.equals("Compagnie")) {
            columnNames = new String[]{"ID", "Sigle", "Nom"};
        } else if (table.equals("Automobile")) {
            columnNames = new String[]{"ID", "Num Plaque", "Marque"};
        } else if (table.equals("Route")) {
            columnNames = new String[]{"ID", "Nom Route", "Ville Départ", "Ville Escale", "Ville Arrivée"};
        }
    }
    @Override
    public int getRowCount() {
       return records.size();
    }

    @Override
    public int getColumnCount() {
         return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object record = records.get(rowIndex);
        switch (columnIndex) {
            case 0: // ID
                if (record instanceof Compagnie) {
                    return ((Compagnie) record).getIdCompagnie();
                } else if (record instanceof Automobile) {
                    return ((Automobile) record).getIdAutomobile();
                } else if (record instanceof Route) {
                    return ((Route) record).getIdRoute();
                }
            case 1: // Sigle / Num Plaque / Nom Route
                if (record instanceof Compagnie) {
                    return ((Compagnie) record).getSigleCompagnie();
                } else if (record instanceof Automobile) {
                    return ((Automobile) record).getNumPlaque();
                } else if (record instanceof Route) {
                    return ((Route) record).getNomRoute();
                }
            case 2: // Nom / Marque / Ville Départ
                if (record instanceof Compagnie) {
                    return ((Compagnie) record).getNomCompagnie();
                } else if (record instanceof Automobile) {
                    return ((Automobile) record).getMarqueAutomobile();
                } else if (record instanceof Route) {
                    return ((Route) record).getVilleDepart();
                }
            case 3: // Ville Escale
                if (record instanceof Route) {
                    return ((Route) record).getVilleEscale();
                }
            case 4: // Ville Arrivée
                if (record instanceof Route) {
                    return ((Route) record).getVilleArrivee();
                }
            default:
                return null;
        }
    }
    

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    
    }
    
}
