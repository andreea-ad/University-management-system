import javax.swing.table.AbstractTableModel;

public class DepartmentTableModel extends AbstractTableModel {
    private Object[][] specializari;
    private int nrSpecializari;
    public DepartmentTableModel(int nr){
        setNrSpecializari(nr);
        specializari = new Object[nr][3];

    }
    public Object[][] getSpecializari(){
        return specializari;
    }

    public void setNrSpecializari(int nrSpecializari) {
        this.nrSpecializari = nrSpecializari;
    }

    @Override
    public int getRowCount() {
        return nrSpecializari;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    public void setValueAt(Object value, int row, int col) {
        specializari[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return specializari[rowIndex][columnIndex];
    }

    public void removeTable(){
        this.specializari = new Object[nrSpecializari][3];
    }
}
