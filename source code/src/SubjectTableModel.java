import javax.swing.table.AbstractTableModel;

public class SubjectTableModel extends AbstractTableModel {
    private Object[][] materii;
    private int nrMaterii;
    public SubjectTableModel(int nr){
        setNrMaterii(nr);
        materii = new Object[nr][7];
    }

    public Object[][] getMaterii(){
        return materii;
    }

    public void setNrMaterii(int nrMaterii){
        this.nrMaterii = nrMaterii;
    }

    @Override
    public int getRowCount() {
        return nrMaterii;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return materii[rowIndex][columnIndex];
    }

    public void setValueAt(Object value, int row, int col) {
        materii[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    public void removeTable(){
        this.materii = new Object[nrMaterii][7];
    }
}
