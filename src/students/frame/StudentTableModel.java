package students.frame;
import java.text.DateFormat;
import java.util.Vector;
import students.logic.Student;

import javax.swing.table.AbstractTableModel;

public class StudentTableModel  extends AbstractTableModel{

    private Vector students;

    public StudentTableModel(Vector students){
        this.students = students;
    }
    @Override
    public int getRowCount() {
        if(students!=null) {
            return students.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    public String getColumnName(int column) {
        String[] colNames = {"Фамилия", "Имя", "Отчество", "Дата"};
        return colNames[column];
    }
    @Override

    public Object getValueAt(int rowIndex, int columnIndex) {
        if(students != null){
            Student st = (Student)students.get(rowIndex);
            switch (columnIndex){
                case 0:
                    return st.getSurName();
                case 1:
                    return st.getFirstName();
                case 2:
                    return st.getPatronymic();
                case 3:
                    return DateFormat.getDateInstance(DateFormat.SHORT).format( st.getDateOfBirth());

            }

        }
        return null;
    }
    public Student getStudent (int rowIndex){
        if(students!=null){
            if(rowIndex<students.size()&&rowIndex>=0){
                return (Student)students.get(rowIndex);
            }
        }
        return null;
    }
}
