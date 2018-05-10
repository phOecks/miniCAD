package cg.main;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Canvas;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import cg.design.formas;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrameCG extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    int WIDTH = 526;
    int HEIGHT = 454;
    Canvas canvas;
    private JTextField txtX1;
    private JTextField txtY1;
    private JTextField txtX2;
    private JTextField txtY2;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCG frame = new FrameCG();
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
	public FrameCG() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblX = new JLabel("X1: ");
		lblX.setBounds(544, 168, 61, 16);
		contentPane.add(lblX);
		
		JLabel lblY = new JLabel("Y1: ");
		lblY.setBounds(544, 196, 61, 16);
		contentPane.add(lblY);
		
		JLabel lblX_1 = new JLabel("X2: ");
		lblX_1.setBounds(544, 222, 61, 16);
		contentPane.add(lblX_1);
		
		JLabel lblY_1 = new JLabel("Y2:");
		lblY_1.setBounds(544, 249, 61, 16);
		contentPane.add(lblY_1);
		
		txtX1 = new JTextField();
		txtX1.setBounds(566, 163, 130, 26);
		contentPane.add(txtX1);
		txtX1.setColumns(10);
		
		txtY1 = new JTextField();
		txtY1.setColumns(10);
		txtY1.setBounds(566, 191, 130, 26);
		contentPane.add(txtY1);
		
		txtX2 = new JTextField();
		txtX2.setColumns(10);
		txtX2.setBounds(566, 217, 130, 26);
		contentPane.add(txtX2);
		
		txtY2 = new JTextField();
		txtY2.setColumns(10);
		txtY2.setBounds(566, 244, 130, 26);
		contentPane.add(txtY2);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(0, 0, 0));
		canvas.setBounds(0, 0, 526, 454);
		canvas.setVisible(true);
		contentPane.add(canvas);
		
		
		JRadioButton rbLinha = new JRadioButton("Linha DDA", false);
		rbLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Graphics g = canvas.getGraphics();
				g.setColor(Color.GREEN);
				
				cg.design.formas.plotar(Float.parseFloat(txtX1.getText()), Float.parseFloat(txtX2.getText()), Float.parseFloat(txtY1.getText()), Float.parseFloat(txtY2.getText()), g);
				
			}
		});
		rbLinha.setBounds(532, 45, 141, 23);
		contentPane.add(rbLinha);
		
		JRadioButton rbTriangulo = new JRadioButton("Triangulo Bresenham", false);
		rbTriangulo.setBounds(532, 80, 164, 23);
		contentPane.add(rbTriangulo);
		
		JRadioButton rdbtnRetanguloBresenham = new JRadioButton("Retangulo Bresenham", false);
		rdbtnRetanguloBresenham.setBounds(532, 115, 177, 23);
		contentPane.add(rdbtnRetanguloBresenham);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbLinha);
		group.add(rbTriangulo);
		group.add(rdbtnRetanguloBresenham);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = canvas.getGraphics();
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
				g.dispose();
				
				txtX1.setText("");
				txtX2.setText("");
				txtY1.setText("");
				txtY2.setText("");
				
				group.clearSelection();
			}
		});
		btnLimpar.setBounds(532, 390, 152, 47);
		contentPane.add(btnLimpar);
		
		JButton btnPlotar = new JButton("Vai!");
		btnPlotar.setBounds(687, 390, 152, 47);
		contentPane.add(btnPlotar);
		
		JComboBox cbxMetodo = new JComboBox();
		cbxMetodo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Mouse", "Teclado"}));
		cbxMetodo.setToolTipText("");
		cbxMetodo.setBounds(665, 6, 130, 27);
		contentPane.add(cbxMetodo);
		
		JLabel lblMetodo = new JLabel("Selecione o método:");
		lblMetodo.setBounds(532, 10, 141, 16);
		contentPane.add(lblMetodo);
		
		
	}
}
