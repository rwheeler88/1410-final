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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String[] data = {"one", "two", "three", "four"};
	private JList<String> list = new JList(data);
	private JComboBox comboBox;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"eeeee", "jhgfjhgfj", "kjghkjghkh"}));
		topPanel.add(comboBox);
		
		textField = new JTextField();
		topPanel.add(textField);
		textField.setColumns(25);
		
		JButton searchButton = new JButton("New button");
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println(textField.getText());
				data[list.getSelectedIndex()]=textField.getText();
				//list.update(getGraphics());
				list.updateUI();
				//list.setSelectedValue(textField.getText(), false);
			}
		});
		topPanel.add(searchButton);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
			}
		});
		
		
<<<<<<< HEAD
		
=======
>>>>>>> f852b66905c14066e18906d6d7031bf501d490d1
		list.setVisibleRowCount(5);
		contentPane.add(list, BorderLayout.CENTER);
		
	}

}