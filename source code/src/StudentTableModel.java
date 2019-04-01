import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {
    private Object[][] studenti;
    private int nrStudenti;
    private final int NR_STUDENTI_IMPLICIT = 10;
    public StudentTableModel(){
        if(nrStudenti==0)
            studenti = new Object[NR_STUDENTI_IMPLICIT][12];
        else
            studenti = new Object[nrStudenti][12];
    }

    public Object[][] getStudenti() {
        return studenti;
    }
    public void setNrStudenti(int nrStudenti){
        this.nrStudenti=nrStudenti;
    }
    public int getRowCount(){
        return nrStudenti;
    }
    public int getColumnCount(){
        return 12;
    }

    public Object getValueAt(int row, int col){
        return studenti[row][col];
    }
    public void setValueAt(Object value, int row, int col) {
        studenti[row][col] = value;
        fireTableCellUpdated(row, col);
    }

}
