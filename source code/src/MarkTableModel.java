import javax.swing.table.AbstractTableModel;
public class MarkTableModel extends AbstractTableModel {
    private Object[][] note;
    private int nrNote;
    private int nrCol;
    public MarkTableModel(int nr, int col){
        setNrNote(nr);
        setNrCol(col);
        note = new Object[nr][col];
    }
    public Object[][] getNote() {
        return note;
    }
    public int getRowCount(){ return nrNote; }
    public void setNrNote(int nrNote){
        this.nrNote=nrNote;
    }
    public void setNrCol(int nrCol){ this.nrCol = nrCol; }
    public int getColumnCount(){ return nrCol; }
    public Object getValueAt(int row, int col){
        return note[row][col];
    }
    public void setValueAt(Object value, int row, int col) {
        note[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    public void removeTable(){
        this.note = new Object[nrNote][nrCol];
    }
}
