package appWekaLDH.wekaFinal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class interfazGrafica {

	private JFrame frmProyectoFinalWeka;
	
	File[] file_data = null;
	private JEditorPane dtrpnResultado;

	/**
	 * Main Principal de la Ventana.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazGrafica window = new interfazGrafica();
					window.frmProyectoFinalWeka.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la aplicación.
	 */
	public interfazGrafica() {
		initialize();
	}

	/**
	 * Inicializa el contennido del frame.
	 */
	private void initialize() {
		frmProyectoFinalWeka = new JFrame();
		frmProyectoFinalWeka.getContentPane().setBackground(Color.WHITE);
		frmProyectoFinalWeka.getContentPane().setLayout(null);
		
		JLabel lblProyectoFinalDe = new JLabel("Proyecto final de Laboratorio de Desarrollo y Herramientas");
		lblProyectoFinalDe.setFont(new Font("Dialog", Font.BOLD, 15));
		lblProyectoFinalDe.setBounds(74, 21, 468, 28);
		frmProyectoFinalWeka.getContentPane().add(lblProyectoFinalDe);

		JPanel panel_resultado = new JPanel();
		panel_resultado.setBackground(Color.WHITE);
		panel_resultado.setBounds(22, 251, 570, 373);
		frmProyectoFinalWeka.getContentPane().add(panel_resultado);
		panel_resultado.setLayout(null);	
		
		dtrpnResultado = new JEditorPane();
		dtrpnResultado.setBounds(2, 2, 550, 313);
		panel_resultado.add(dtrpnResultado);
		dtrpnResultado.setEditable(false);

		
		final JScrollPane scrollBar = new JScrollPane(dtrpnResultado);
		scrollBar.setBounds(10, 39, 554, 313);
		panel_resultado.add(scrollBar);
		
		JLabel lblResultados_1 = new JLabel("Resultados:");
		lblResultados_1.setBounds(10, 11, 116, 16);
		panel_resultado.add(lblResultados_1);
		
		JPanel panel_archivo = new JPanel();
		panel_archivo.setBackground(Color.WHITE);
		panel_archivo.setBounds(74, 69, 461, 37);
		frmProyectoFinalWeka.getContentPane().add(panel_archivo);
		
		JButton btnCargarArchvio = new JButton("Cargar Archvio");
		panel_archivo.add(btnCargarArchvio);
		
		JLabel lblNombreArchivo = new JLabel("Nombre_Archivo");
		panel_archivo.add(lblNombreArchivo);
		
		JPanel panel_seleccion = new JPanel();
		panel_seleccion.setBackground(Color.WHITE);
		panel_seleccion.setBounds(22, 118, 570, 80);
		frmProyectoFinalWeka.getContentPane().add(panel_seleccion);
		
		JButton btnKmeans = new JButton("K-MEANS");
		panel_seleccion.add(btnKmeans);
		
		JButton btnRegresinS = new JButton("REGRESIÓN S");
		panel_seleccion.add(btnRegresinS);
		
		JButton btnRegresinM = new JButton("REGRESIÓN M");
		panel_seleccion.add(btnRegresinM);
		
		JButton btnRamdonForest = new JButton("RAMDON FOREST");
		panel_seleccion.add(btnRamdonForest);
		
		JButton btnMp = new JButton("MP5");
		panel_seleccion.add(btnMp);
		
		JButton btnZeror = new JButton("ZeroR");
		panel_seleccion.add(btnZeror);
		
		JButton btnJ = new JButton("J48");
		panel_seleccion.add(btnJ);
		
		JButton btnKstart = new JButton("KStart");
		
		panel_seleccion.add(btnKstart);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(22, 210, 570, 29);
		frmProyectoFinalWeka.getContentPane().add(panel);
		
		JLabel lblAlgortimoSeleccionado = new JLabel("Algortimo Seleccionado:");
		panel.add(lblAlgortimoSeleccionado);
		
		JLabel lblAlgoritmo = new JLabel("algoritmo");
		panel.add(lblAlgoritmo);
		
		btnKstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LazyKStar kstar = new LazyKStar(file_data[0]);
				try {
					dtrpnResultado.setText(kstar.PrintResult());
					} catch (Exception e1) {
						e1.printStackTrace();
						}
				}
			});
		
		btnCargarArchvio.addActionListener(new ActionListener() {
			File[] file_input = null;
			public void actionPerformed(ActionEvent e) {
				file_input= new FileSelector().chooseFiles();
                if(file_input != null){
                		//System.out.println( "Fichero cargado correctamente" );
                		file_data = file_input;
                }
			}
		});
		
		frmProyectoFinalWeka.setBackground(Color.RED);
		frmProyectoFinalWeka.setTitle("Proyecto Final Weka LDH 2017/18");
		frmProyectoFinalWeka.setBounds(100, 100, 614, 652);
		frmProyectoFinalWeka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}