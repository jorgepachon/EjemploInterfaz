import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaEjemplo {

	private JFrame frmEjemploDeManejo;
	private JTable Mitabla;
	private JTextField txtfNombre;
	private JTextField txtfApellido;
	private JTextField txtMostrarNombre;
	private JTextField txtMostrarApellido;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEjemplo window = new VentanaEjemplo();
					window.frmEjemploDeManejo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaEjemplo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEjemploDeManejo = new JFrame();
		frmEjemploDeManejo.setTitle("ejemplo de manejo datos en base datos");
		frmEjemploDeManejo.setBounds(100, 100, 525, 616);
		frmEjemploDeManejo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtfNombre = new JTextField();
		txtfNombre.setColumns(10);
		
		txtfApellido = new JTextField();
		txtfApellido.setColumns(10);
		
		JButton btnInsertar = new JButton("insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] row={txtfNombre.getText(), txtfApellido.getText()};
				
				((DefaultTableModel)Mitabla.getModel()).addRow(row);
				txtfNombre.setText(null);
				txtfApellido.setText(null);
			}
		});
		
		JButton btnModificar = new JButton("modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Mitabla.getSelectedRow()>=0){
					Mitabla.setValueAt(txtMostrarNombre.getText(), Mitabla.getSelectedRow(), 0);
					Mitabla.setValueAt(txtMostrarApellido.getText(), Mitabla.getSelectedRow(), 1);
				}
			}
		});
		
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Mitabla.getSelectedRow()>=0){
					((DefaultTableModel)Mitabla.getModel()).removeRow(Mitabla.getSelectedRow());
					txtMostrarNombre.setText(null);
					txtMostrarApellido.setText(null);
				}
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		
		txtMostrarNombre = new JTextField();
		txtMostrarNombre.setColumns(10);
		
		txtMostrarApellido = new JTextField();
		txtMostrarApellido.setColumns(10);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(btnSalir, "¿Desea realmente salir del sistema?",
		                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		            System.exit(0);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frmEjemploDeManejo.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSalir))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(51)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(txtfNombre, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
										.addComponent(txtfApellido, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
									.addComponent(btnInsertar, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
									.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
									.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)))
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblApellidos)
									.addComponent(lblNombre))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(txtMostrarNombre, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
									.addComponent(txtMostrarApellido, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)))))
					.addGap(63))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtMostrarNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(txtMostrarApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnInsertar)
					.addGap(18)
					.addComponent(btnModificar)
					.addGap(18)
					.addComponent(btnEliminar)
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addComponent(btnSalir)
					.addContainerGap())
		);
		
		Mitabla = new JTable();
		Mitabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(Mitabla.getSelectedRow()>=0){
					txtMostrarNombre.setText(Mitabla.getValueAt(Mitabla.getSelectedRow(), 0).toString());
					txtMostrarApellido.setText(Mitabla.getValueAt(Mitabla.getSelectedRow(), 1).toString());
				}
			}
		});
		Mitabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Mitabla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Mitabla.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"nombre", "apellidos"
			}
		));
		scrollPane.setViewportView(Mitabla);
		frmEjemploDeManejo.getContentPane().setLayout(groupLayout);
	}
}
