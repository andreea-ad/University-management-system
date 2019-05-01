import javax.swing.table.AbstractTableModel;

public class TeacherTableModel extends AbstractTableModel {
    private Object[][] profesori;
    private int nrProfesori;
    public TeacherTableModel(int nr){
        setNrProfesori(nr);
        profesori = new Object[nr][11];
    }

    public Object[][] getProfesori() {
        return profesori;
    }
    public void setNrProfesori(int nrProfesori){
        this.nrProfesori = nrProfesori;
    }
    public int getRowCount(){
        return nrProfesori;
    }
    public int getColumnCount(){
        return 11;
    }
    public Object getValueAt(int row, int col){
        return profesori[row][col];
    }
    public void setValueAt(Object value, int row, int col) {
        profesori[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    public void removeTable(){
        this.profesori = new Object[nrProfesori][11];
    }
}
