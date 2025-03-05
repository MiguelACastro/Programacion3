package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Aplicacion {

	private JFrame frmRegistroDeUsuarios;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacion window = new Aplicacion();
					window.frmRegistroDeUsuarios.setVisible(true);
					window.frmRegistroDeUsuarios.setMinimumSize(window.frmRegistroDeUsuarios.getMinimumSize());
					window.frmRegistroDeUsuarios.setPreferredSize(window.frmRegistroDeUsuarios.getPreferredSize());
					window.frmRegistroDeUsuarios.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aplicacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeUsuarios = new JFrame();
		frmRegistroDeUsuarios.setTitle("Registro de usuarios");
		frmRegistroDeUsuarios.setBounds(100, 100, 1151, 656);
		frmRegistroDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel.setBackground(new Color(127, 255, 0));
		frmRegistroDeUsuarios.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 5, 5));
		
		JPanel panelDatosGen = new JPanel();
		panelDatosGen.setBackground(new Color(176, 224, 230));
		panelDatosGen.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Datos generales", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel.add(panelDatosGen);
		
		JLabel lblNombres = new JLabel("Nombres");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNombres_1 = new JLabel("Apellido paterno");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNombres_2 = new JLabel("Apellido materno");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de nacimiento");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		Image imagenCalendario = new ImageIcon("img/calendar.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(imagenCalendario));
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Masculino");
		rdbtnNewRadioButton.setBackground(new Color(176, 224, 230));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Femenino");
		rdbtnNewRadioButton_1.setBackground(new Color(176, 224, 230));
		
		ButtonGroup grupoSexo = new ButtonGroup();
		
		grupoSexo.add(rdbtnNewRadioButton);
		grupoSexo.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Nacionalidad");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Ecuador", "México", "Paraguay", "Perú", "Uruguay", "Venezuela"}));
		comboBox.setSelectedIndex(6);
		
		GroupLayout gl_panelDatosGen = new GroupLayout(panelDatosGen);
		gl_panelDatosGen.setHorizontalGroup(
			gl_panelDatosGen.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelDatosGen.createSequentialGroup()
					.addContainerGap(178, Short.MAX_VALUE)
					.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDatosGen.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panelDatosGen.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelDatosGen.createSequentialGroup()
								.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNombres_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNombres_2)
									.addComponent(lblNombres, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.LEADING)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
								.addGap(166))
							.addGroup(gl_panelDatosGen.createSequentialGroup()
								.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_2)
									.addComponent(lblNewLabel_3))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.LEADING)
									.addComponent(rdbtnNewRadioButton)
									.addComponent(rdbtnNewRadioButton_1)
									.addGroup(gl_panelDatosGen.createSequentialGroup()
										.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textField_3, Alignment.LEADING))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
								.addGap(193)))))
		);
		gl_panelDatosGen.setVerticalGroup(
			gl_panelDatosGen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatosGen.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombres))
					.addGap(12)
					.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombres_1))
					.addGap(16)
					.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombres_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(rdbtnNewRadioButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnNewRadioButton_1)
					.addGap(18)
					.addGroup(gl_panelDatosGen.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		panelDatosGen.setLayout(gl_panelDatosGen);
		
		JPanel panelPerfil = new JPanel();
		panelPerfil.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Perfil del usuario", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(51, 51, 51)));
		panelPerfil.setBackground(new Color(250, 128, 114));
		panel.add(panelPerfil);
		panelPerfil.setLayout(new BoxLayout(panelPerfil, BoxLayout.Y_AXIS));
		
		Image imagenUsuario = new ImageIcon("img/foto_usuario.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		
		JLabel fotoUsuario = new JLabel();
		fotoUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		fotoUsuario.setIcon(new ImageIcon(imagenUsuario));
		panelPerfil.add(fotoUsuario);
		
		Component verticalGlue_3 = Box.createVerticalGlue();
		panelPerfil.add(verticalGlue_3);
		
		JCheckBox mostrarFoto = new JCheckBox("Mostrar foto de perfil");
		mostrarFoto.setAlignmentX(Component.CENTER_ALIGNMENT);
		mostrarFoto.setBackground(new Color(250, 128, 114));
		panelPerfil.add(mostrarFoto);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		panelPerfil.add(verticalGlue_2);
		
		JCheckBox mostrarFecha = new JCheckBox("Mostrar fecha de nacimiento");
		mostrarFecha.setAlignmentX(Component.CENTER_ALIGNMENT);
		mostrarFecha.setBackground(new Color(250, 128, 114));
		panelPerfil.add(mostrarFecha);
		
		JPanel panelDatosOpc = new JPanel();
		panelDatosOpc.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Datos opcionales", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panelDatosOpc.setBackground(new Color(250, 128, 114));
		panel.add(panelDatosOpc);
		panelDatosOpc.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Descripción");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatosOpc.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Preferencias");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatosOpc.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane1 = new JScrollPane(textArea);
		panelDatosOpc.add(scrollPane1);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Cantar", "Escuchar musica", "Leer", "Deportes", "Otros"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		JScrollPane scrollPane2 = new JScrollPane(list);
		panelDatosOpc.add(scrollPane2);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(new Color(176, 224, 230));
		panelBotones.setBorder(new EmptyBorder(80, 100, 80, 100));
		panel.add(panelBotones);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
		
		Image imagenGuardar = new ImageIcon("img/save.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setForeground(new Color(255, 255, 255));
		botonGuardar.setIcon(new ImageIcon(imagenGuardar));
		botonGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonGuardar.setBackground(new Color(0, 0, 0));
		botonGuardar.setAlignmentY(Component.TOP_ALIGNMENT);
		botonGuardar.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelBotones.add(botonGuardar);
		
		Component verticalGlue = Box.createVerticalGlue();
		panelBotones.add(verticalGlue);
		
		Image imagenNuevo = new ImageIcon("img/cancel.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		JButton botonNuevo = new JButton("Nuevo    ");
		botonNuevo.setBackground(new Color(0, 0, 0));
		botonNuevo.setForeground(SystemColor.text);
		botonNuevo.setIcon(new ImageIcon(imagenNuevo));
		botonNuevo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelBotones.add(botonNuevo);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		panelBotones.add(verticalGlue_1);
		
		Image imagenSalir = new ImageIcon("img/home.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		JButton botonSalir = new JButton("Salir      ");
		botonSalir.setForeground(new Color(255, 255, 255));
		botonSalir.setBackground(new Color(0, 0, 0));
		botonSalir.setIcon(new ImageIcon(imagenSalir));
		botonSalir.setAlignmentX(0.5f);
		panelBotones.add(botonSalir);
	}
}
