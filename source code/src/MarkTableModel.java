import javax.swing.table.AbstractTableModel;
import java.util.*;
public class MarkTableModel extends AbstractTableModel {
    private Object[][] note;
    private int nrNote;
    private final int NR_NOTE_IMPLICIT = 20;
    public MarkTableModel(int nrColoane){
        if(nrNote==0)
            note = new Object[NR_NOTE_IMPLICIT][nrColoane];
        else
            note = new Object[nrNote][nrColoane];
    }

    public Object[][] getNote() {
        return note;
    }
    public int getNrNote(){ return nrNote; }
    public void setNrNote(int nrNote){
        this.nrNote=nrNote;
    }
    public int getRowCount(){
        return nrNote;
    }
    public int getColumnCount(){
        return 5;
    }

    public Object getValueAt(int row, int col){
        return note[row][col];
    }
    public void setValueAt(Object value, int row, int col) {
        note[row][col] = value;
        fireTableCellUpdated(row, col);
    }

}
