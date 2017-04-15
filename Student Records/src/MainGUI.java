import java.awt.BorderLayout;
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

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String[] data = {"one", "two", "three", "four","five"};
	private JComboBox comboBox;
	private final JFileChooser fc = new JFileChooser();
	private File openFile;
	
	Object[][] datao = {
		    {"Kathy", "Smith",
		     "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe",
		     "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black",
		     "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White",
		     "Speed reading", new Integer(20), new Boolean(true)},
		    {"Joe", "Brown",
		     "Pool", new Integer(10), new Boolean(false)}
		};
	private JScrollPane scrollPane;
	private JTable table;

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
		Integer n = testDialog(new JFrame());
		processOption(n);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(null);
		contentPane.add(topPanel, BorderLayout.NORTH);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"eeeee", "jhgfjhgfj", "kjghkjghkh"}));
		topPanel.add(comboBox);
		//
		textField = new JTextField();
		topPanel.add(textField);
		textField.setText(n.toString());
		textField.setColumns(25);
		
		JButton searchButton = new JButton("New button");
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		topPanel.add(searchButton);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(datao,data);
		scrollPane.setViewportView(table);

		
	}
	
	public void processOption(int n)
	{
		switch(n)
		{
		case 0:
			openFile = openFileChooser(fc); 
			this.setTitle(openFile.toString());
			break;
		default:
			break;
		}
	}
	
	public int testDialog(JFrame frame)
	{
		Object[] options = {"Open Existing Database",
                "New Empty Database",
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
	
	public File openFileChooser(JFileChooser fc)
	{
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
            return fc.getSelectedFile();
		else 
			return new File("");
	}

}
