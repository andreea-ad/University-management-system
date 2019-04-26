import javax.swing.table.AbstractTableModel;

public class TeacherTableModel extends AbstractTableModel {
    private Object[][] profesori;
    private int nrProfesori;
    private final int NR_PROFESORI_IMPLICIT = 10;
    public TeacherTableModel(){
        if(nrProfesori==0)
            profesori = new Object[NR_PROFESORI_IMPLICIT][11];
        else
            profesori = new Object[nrProfesori][11];
    }

    public Object[][] getProfesori() {
        return profesori;
    }
    public void setNrProfesori(int nrProfesori){
        this.nrProfesori=nrProfesori;
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

}
