package students.frame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.Vector;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import students.logic.Group;
import students.logic.ManagementSystem;
import students.logic.Student;

public class StudentsFrame extends JFrame {
    ManagementSystem ms = ManagementSystem.getInstance();
    private JList grpList;
    private JList stdList;
    private JSpinner spYear;

    public StudentsFrame () {
        getContentPane().setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("Год обучения"));
        SpinnerModel sm = new SpinnerNumberModel(2006,1900,2100,1);
        spYear = new JSpinner(sm);
        top.add (spYear);

        JPanel bot = new JPanel();
        bot.setLayout(new FlowLayout());

        JPanel left = new JPanel();
        left.setLayout(new BorderLayout());
        left.setBorder(new BevelBorder(BevelBorder.RAISED));

        Vector<Group> gr = new Vector<Group>(ms.getGroups());
        left.add(new JLabel("Группы:"),BorderLayout.NORTH);
        grpList = new JList(gr);
        left.add(new JScrollPane(grpList),BorderLayout.CENTER);

        



    }
}
