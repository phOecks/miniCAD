package cg.main;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Shape;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Canvas;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import cg.design.formas;


public class FrameCG extends JFrame {

	/**
	 * Declaração de váriaveis
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int WIDTH = 800;
	private int HEIGHT = 600;
    private Canvas canvas;
    private JTextField txtX1;
    private JTextField txtY1;
    private JTextField txtX2;
    private JTextField txtY2;
    private JTextField txtRaio;
    private JLabel lblX1;
    private JLabel lblX2;
    private JLabel lblRaio;
    private JLabel lblY1;
    private JLabel lblY2;
    private JRadioButton rbLinha;
    private JRadioButton rbTriangulo;
    private JRadioButton rdbtnRetanguloBresenham;
    private JRadioButton rbCirculo;
    private ButtonGroup group;
    private JButton btnLimpar;
    private JButton btnPlotar;
    private JComboBox<String> cbxMetodo;
    private JLabel lblMetodo;
    private List<Shape> myShapes = new ArrayList<Shape>();

    
    
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
	 * Construtor que chama o método para iniciar os componentes
	 */
	public FrameCG() {
		
		initComponents();
		acaoExecutada();
		
	}
	
	/*
	 * Ação executada pelos componentes
	 */
	
	 private void acaoExecutada() {
		 
		 cbxMetodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Object qualMetodo = cbxMetodo.getSelectedItem();
				 
				 if(qualMetodo.toString()=="Mouse") {
					 	lblX1.setVisible(false);
						lblX2.setVisible(false);
						lblY1.setVisible(false);
						lblY2.setVisible(false);
						lblRaio.setVisible(false);
						
						txtX1.setVisible(false);
						txtX2.setVisible(false);
						txtY1.setVisible(false);
						txtY2.setVisible(false);
						txtRaio.setVisible(false);
				 }
			}
		 });
 
		rbLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object qualMetodo = cbxMetodo.getSelectedItem();

				if (qualMetodo.toString() == "Selecione") {
					JOptionPane.showMessageDialog(null,
							"Por favor, selecione o método de entrada:\n\nMOUSE ou TECLADO");

				} else if (qualMetodo.toString() == "Mouse") {
					lblX1.setVisible(false);
					lblX2.setVisible(false);
					lblY1.setVisible(false);
					lblY2.setVisible(false);
					lblRaio.setVisible(false);

					txtX1.setVisible(false);
					txtX2.setVisible(false);
					txtY1.setVisible(false);
					txtY2.setVisible(false);
					txtRaio.setVisible(false);
					
					canvas.addMouseListener(new MouseListener() {
						
						int xi = 0, yi = 0, xf = 0, yf = 0;
						
						
						@Override
						public void mouseReleased(MouseEvent e) {
							this.xf = e.getX();
							this.yf = e.getY();
							
							Graphics g = canvas.getGraphics();
							g.setColor(Color.GREEN);

							formas.desenhaLinha(xi, xf,yi, yf, g);
							canvas.removeMouseListener(this);
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							this.xi = e.getX();
							this.yi = e.getY();
							
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
					
					
				} else {
					lblX1.setVisible(false);
					lblX2.setVisible(false);
					lblY1.setVisible(false);
					lblY2.setVisible(false);
					lblRaio.setVisible(false);

					txtX1.setVisible(false);
					txtX2.setVisible(false);
					txtY1.setVisible(false);
					txtY2.setVisible(false);
					txtRaio.setVisible(false);

					txtX1.setText("");
					txtX2.setText("");
					txtY1.setText("");
					txtY2.setText("");
					txtRaio.setText("");

					lblX1.setVisible(true);
					lblX2.setVisible(true);
					lblY1.setVisible(true);
					lblY2.setVisible(true);

					txtX1.setVisible(true);
					txtX2.setVisible(true);
					txtY1.setVisible(true);
					txtY2.setVisible(true);
				}
			}
		});

		rbCirculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object qualMetodo = cbxMetodo.getSelectedItem();

				if (qualMetodo.toString() == "Selecione") {
					JOptionPane.showMessageDialog(null,
							"Por favor, selecione o método de entrada:\n\nMOUSE ou TECLADO");

				} else if (qualMetodo.toString() == "Mouse") {
					lblX1.setVisible(false);
					lblX2.setVisible(false);
					lblY1.setVisible(false);
					lblY2.setVisible(false);
					lblRaio.setVisible(false);

					txtX1.setVisible(false);
					txtX2.setVisible(false);
					txtY1.setVisible(false);
					txtY2.setVisible(false);
					txtRaio.setVisible(false);
					
					canvas.addMouseListener(new MouseListener() {
						
						int xi = 0, yi = 0, xf = 0, yf = 0;
						
						
						@Override
						public void mouseReleased(MouseEvent e) {
							this.xf = e.getX();
							this.yf = e.getY();
							
							int raio = (int)Math.sqrt(Math.pow(this.xi - this.xf, 2) + Math.pow(this.yi - this.yf, 2));
							int Xc = xf, Yc=yf;
							
							Graphics g = canvas.getGraphics();
							g.setColor(Color.GREEN);

							formas.desenhaCirculo(Xc, Yc, raio, g);
							canvas.removeMouseListener(this);
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							this.xi = e.getX();
							this.yi = e.getY();
							
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
					
				} else {

					lblY1.setVisible(false);
					lblY2.setVisible(false);
					lblRaio.setVisible(false);

					txtY1.setVisible(false);
					txtY2.setVisible(false);
					lblRaio.setVisible(false);

					txtX1.setText("");
					txtX2.setText("");
					txtRaio.setText("");

					lblX1.setVisible(true);
					lblX2.setVisible(true);
					lblRaio.setVisible(true);

					txtX1.setVisible(true);
					txtX2.setVisible(true);
					txtRaio.setVisible(true);
				}
			}
		});

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

		btnPlotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object qualMetodo = cbxMetodo.getSelectedItem();

				if (qualMetodo.toString() == "Selecione") {
					JOptionPane.showMessageDialog(null,
							"Por favor, selecione o método de entrada:\n\nMOUSE ou TECLADO");

				} else {

					if (rbCirculo.isSelected()) {
						Graphics g = canvas.getGraphics();
						g.setColor(Color.GREEN);

						formas.desenhaCirculo(Integer.parseInt(txtX1.getText()), Integer.parseInt(txtX2.getText()),
								Integer.parseInt(txtRaio.getText()), g);

					} else if (rbLinha.isSelected()) {
						Graphics g = canvas.getGraphics();
						g.setColor(Color.GREEN);

						formas.desenhaLinha(Integer.parseInt(txtX1.getText()), Integer.parseInt(txtX2.getText()),
								Integer.parseInt(txtY1.getText()), Integer.parseInt(txtY2.getText()), g);

					} else if (rbTriangulo.isSelected()) {

					} else if (rdbtnRetanguloBresenham.isSelected()) {

					}
				}
			}
		});
	}
	
	/*
	 * Cria o frame e os componentes na tela
	 */
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1131, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblX1 = new JLabel("X1: ");
		lblX1.setBounds(818, 223, 61, 16);
		contentPane.add(lblX1);
		lblX1.setVisible(false);
		
		lblY1 = new JLabel("Y1: ");
		lblY1.setBounds(818, 256, 61, 16);
		contentPane.add(lblY1);
		lblY1.setVisible(false);
		
		lblX2 = new JLabel("X2: ");
		lblX2.setBounds(976, 223, 61, 16);
		contentPane.add(lblX2);
		lblX2.setVisible(false);
		
		lblY2 = new JLabel("Y2:");
		lblY2.setBounds(976, 256, 61, 16);
		contentPane.add(lblY2);
		lblY2.setVisible(false);
		
		lblRaio = new JLabel("Raio: ");
		lblRaio.setBounds(808, 256, 61, 16);
		contentPane.add(lblRaio);
		lblRaio.setVisible(false);
		
		txtX1 = new JTextField();
		txtX1.setBounds(840, 218, 130, 26);
		contentPane.add(txtX1);
		txtX1.setColumns(10);
		txtX1.setVisible(false);
		
		txtY1 = new JTextField();
		txtY1.setColumns(10);
		txtY1.setBounds(840, 251, 130, 26);
		contentPane.add(txtY1);
		txtY1.setVisible(false);
		
		txtX2 = new JTextField();
		txtX2.setColumns(10);
		txtX2.setBounds(998, 218, 130, 26);
		contentPane.add(txtX2);
		txtX2.setVisible(false);
		
		txtY2 = new JTextField();
		txtY2.setColumns(10);
		txtY2.setBounds(998, 251, 130, 26);
		contentPane.add(txtY2);
		txtY2.setVisible(false);
		
		txtRaio = new JTextField();
		txtRaio.setColumns(10);
		txtRaio.setBounds(840, 251, 130, 26);
		contentPane.add(txtRaio);
		txtRaio.setVisible(false);
		
		canvas = new Canvas();
		canvas.setBackground(new Color(0, 0, 0));
		canvas.setBounds(0, 0, WIDTH, HEIGHT);
		canvas.setVisible(true);
		contentPane.add(canvas);
		
		rbLinha = new JRadioButton("Linha", false);
		rbLinha.setBounds(806, 45, 141, 23);
		contentPane.add(rbLinha);
		
		rbTriangulo = new JRadioButton("Triângulo", false);
		rbTriangulo.setBounds(806, 80, 164, 23);
		contentPane.add(rbTriangulo);
		
		rdbtnRetanguloBresenham = new JRadioButton("Retangulo", false);
		rdbtnRetanguloBresenham.setBounds(806, 115, 177, 23);
		contentPane.add(rdbtnRetanguloBresenham);
		
		rbCirculo = new JRadioButton("Circulo", false);
		rbCirculo.setBounds(806, 152, 177, 23);
		contentPane.add(rbCirculo);
		
		group = new ButtonGroup();
		group.add(rbLinha);
		group.add(rbTriangulo);
		group.add(rdbtnRetanguloBresenham);
		group.add(rbCirculo);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(806, 390, 152, 47);
		contentPane.add(btnLimpar);
		
		btnPlotar = new JButton("Vai!");
		btnPlotar.setBounds(961, 390, 152, 47);
		contentPane.add(btnPlotar);
		
		cbxMetodo = new JComboBox<String>();
		cbxMetodo.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecione", "Mouse", "Teclado"}));
		cbxMetodo.setToolTipText("");
		cbxMetodo.setBounds(939, 6, 189, 27);
		contentPane.add(cbxMetodo);
		
		lblMetodo = new JLabel("Selecione o método:");
		lblMetodo.setBounds(806, 10, 141, 16);
		contentPane.add(lblMetodo);	
	}

  
}
