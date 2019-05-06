import javax.swing.table.AbstractTableModel;

public class FacultyTableModel extends AbstractTableModel {
    private Object[][] facultati;
    private int nrFacultati;
    public FacultyTableModel(int nr){
        setNrFacultati(nr);
        facultati = new Object[nr][1];
    }

    public Object[][] getFacultati(){
        return facultati;
    }

    public void setNrFacultati(int nrFacultati){
        this.nrFacultati = nrFacultati;
    }

    @Override
    public int getRowCount() {
        return nrFacultati;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return facultati[rowIndex][columnIndex];
    }

    public void setValueAt(Object value, int row, int col) {
        facultati[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    public void removeTable(){
        this.facultati = new Object[nrFacultati][1];
    }

}
