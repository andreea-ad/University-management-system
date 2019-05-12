import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {
    private Object[][] studenti;
    private int nrStudenti;
    public StudentTableModel(int nr){
        setNrStudenti(nr);
        studenti = new Object[nr][12];
    }
    public Object[][] getStudenti() {
        return studenti;
    }
    public void setNrStudenti(int nrStudenti){
        this.nrStudenti = nrStudenti;
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
    public void removeTable(){
        this.studenti = new Object[nrStudenti][12];
    }
}
