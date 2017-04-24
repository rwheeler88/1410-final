import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JTree;
import javax.swing.JMenuBar;

public class MainGUI extends JFrame {
	
	private static boolean listEditable;
	private JPanel contentPane;
	private JTextField textField;
	private String[] catagoryHeader = {"S Number", "First", "Last", ""};
	private String[] searchCatagories = {"By First Name","By Last Name","By S Number"};
	
	private static final JFileChooser fc = new JFileChooser();
	private File openFile;
	Object[][] datao;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton btnAddNew;
	private JPanel panel;
	private JPanel panel_1;
	private JComboBox comboBox;
	private JButton searchButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		Integer n = openOptionDialog(new JFrame());
		processOption(n);
		openInputField("Bill Gate?");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			setBounds(100, 100, 600, 400);
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JPanel topPanel = new JPanel();
			topPanel.setBorder(null);
			contentPane.add(topPanel, BorderLayout.NORTH);
			topPanel.setLayout(new BorderLayout(0, 0));
			
			panel_1 = new JPanel();
			topPanel.add(panel_1, BorderLayout.NORTH);
			
			JButton openDatabaseButton = new JButton("Open Another Database");
			panel_1.add(openDatabaseButton);
			openDatabaseButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					processOption(openOptionDialog(new JFrame()));
				}
			});
			
			panel = new JPanel();
			topPanel.add(panel, BorderLayout.SOUTH);
			
			btnAddNew = new JButton("Add New");
			panel.add(btnAddNew);
			//
			textField = new JTextField();
			panel.add(textField);
			textField.setColumns(25);
			
			comboBox = new JComboBox(searchCatagories);
			panel.add(comboBox);
			
			searchButton = new JButton("Search");
			panel.add(searchButton);
			btnAddNew.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					addNew.addStudent();
					datao = getFormattedList(addNew.students);
					tableModel = new DefaultTableModel(datao,catagoryHeader);
					table.setModel(tableModel);
				}
			});
			
			scrollPane = new JScrollPane();
			contentPane.add(scrollPane, BorderLayout.CENTER);
			table = new JTable();
			table.putClientProperty("terminateEditOnFocusLost", true);
			updateTable();
			scrollPane.setViewportView(table);

	}
	
	public void processOption(int n)
	{
		ArrayList<Person> people;
		switch(n)
		{
		case 0:
			try{					
			people = Person.reader();
			}catch(Exception e){break;}
			catagoryHeader[3] = "GPA";
			datao = getFormattedList(people);
			addNew.students = people;
			updateTable();
			break;
		case 1:
			try{	 people = Teacher.reader();
			System.out.println("win1");
			}catch(Exception e){people = null;}
			catagoryHeader[3] = "Class";
			datao = getFormattedList(people);
			break;
		case 2:
			//System.exit(0);
			//break;
		default:
			datao = new Object[1][4];
			datao[0][0] = "";
			datao[0][1] = "";
			datao[0][2] = "";
			datao[0][3] = "";
			break;
		}
		
	}
	
	public static int openOptionDialog(JFrame frame)
	{
		Object[] options = {"Open Existing Database",
                "Open Teacher Database",
                "Quit"};
		int n = JOptionPane.showOptionDialog(frame,
		"Would you like some green eggs to go "
		+ "with that ham?",
		"A Silly Question",
		JOptionPane.YES_NO_CANCEL_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,
		options,
		options[2]);
		
		return n;
	}
	
	public static File openFileChooser()
	{
		int returnVal = fc.showOpenDialog(new JFrame());
		if (returnVal == JFileChooser.APPROVE_OPTION) 
            return fc.getSelectedFile();
		else 
			return new File("");
	}
	
	public static String openInputField(String prompt)
	{
		return JOptionPane.showInputDialog(prompt);
	}
	
	public void updateTable()
	{
		tableModel = new DefaultTableModel(datao,catagoryHeader);
		table.setModel(tableModel);
	}
	
	/**
	 * 
	 * @param list
	 * 	The list of people to be formatted for display
	 * @return Returns a multi-dimensional array of Objects so the table can display the list
	 */
	public static Object[][] getFormattedList(ArrayList<Person> list)
	{
		Object[][] objects = new Object[list.size()][]; 
		for(Person current : list)
		{
			objects[list.indexOf(current)] = current.toStringArray();
			System.out.println("Read in person: " + Arrays.toString(objects[list.indexOf(current)]));
			
		}
		return objects;
	}

}
