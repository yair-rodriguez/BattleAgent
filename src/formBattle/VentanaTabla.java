package formBattle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import utilidades.GestionCeldas;
import utilidades.GestionEncabezadoTabla;
import utilidades.ModeloTabla;
import utilidades.Utilidades;
import getTable.getValueCells;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaTabla extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JScrollPane scrollPaneTabla;
	private JTable tablaBattleShip;
	ArrayList<getValueCells> listaBarcos;//lista que simula las coordenadas default 0
	
	ModeloTabla modelo;//modelo definido en la clase ModeloTabla
	private int filasTabla;
	private int columnasTabla;

	/**
	 * Create the frame.
	 */
	public VentanaTabla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1121, 453);
		
		iniciarComponentes();
		setLocationRelativeTo(null);
		construirTabla();
	}

	private void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTablaBattleShip = new JLabel("< =========== BattleShips =========== >");
		lblTablaBattleShip.setFont(new Font("Rockwell", Font.BOLD, 25));
		contentPane.add(lblTablaBattleShip, BorderLayout.NORTH);
		
		scrollPaneTabla = new JScrollPane();
		contentPane.add(scrollPaneTabla);
		
		tablaBattleShip = new JTable();
		tablaBattleShip.setBackground(Color.WHITE);
		tablaBattleShip.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tablaBattleShip.addMouseListener(this);
		//tablaSeguimiento.addKeyListener(this);
		tablaBattleShip.setOpaque(false);
		scrollPaneTabla.setViewportView(tablaBattleShip);
		
	}
	
	/**
	 * Metodo que permite construir la tabla de barcos
	 * se crean primero las columnas y luego se asigna por default 0
	 */
	private void construirTabla() {
		
		listaBarcos=consultarListaBarcos();
		
		ArrayList<String> titulosList=new ArrayList<>();
		
		titulosList.add("COORD");
		titulosList.add("A");
		titulosList.add("B");
		titulosList.add("C");
		titulosList.add("D");
		titulosList.add("E");
		titulosList.add("F");
		titulosList.add("G");
		titulosList.add("H");
		titulosList.add("I");
		
				
		//se asignan las columnas al arreglo para enviarse al momento de construir la tabla
		String titulos[] = new String[titulosList.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i]=titulosList.get(i);
		}
		/*obtenemos los datos de la lista y los guardamos en la matriz
		 * que luego se manda a construir la tabla
		 */
		Object[][] data =obtenerMatrizDatos(titulosList);
		construirTabla(titulos,data);
		
	}

	/**
	 * Permite simular el llenado de BARCOS en una lista
	 * que posteriormente alimentar� la tabla
	 * @return
	 */
	private ArrayList<getValueCells> consultarListaBarcos() {
		ArrayList<getValueCells> lista=new ArrayList<>();
		
		lista.add(new getValueCells(1, 0, 0, 0, 0,0,0, 0, 0, 0));
                lista.add(new getValueCells(2, 0, 0, 0, 0,0,0, 0, 0, 0));
                lista.add(new getValueCells(3, 0, 0, 0, 0,0,0, 0, 0, 0));
                lista.add(new getValueCells(4, 0, 0, 0, 0,0,0, 0, 0, 0));
                lista.add(new getValueCells(5, 0, 0, 0, 0,0,0, 0, 0, 0));
                lista.add(new getValueCells(6, 0, 0, 0, 0,0,0, 0, 0, 0));
                lista.add(new getValueCells(7, 0, 0, 0, 0,0,0, 0, 0, 0));
                lista.add(new getValueCells(8, 0, 0, 0, 0,0,0, 0, 0, 0));
                lista.add(new getValueCells(9, 0, 0, 0, 0,0,0, 0, 0, 0));
      	
		return lista;
	}

	/**
	 * Llena la informaci�n de la tabla usando la lista de los barcos ingresados 
	 * anteriormente, guardandola en una matriz que se retorna con toda 
	 * la informaci�n para luego ser asignada al modelo
	 * @param titulosList
	 * @return
	 */
	private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {
		
		/*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los barcos, mientras que las columnas son estaticas 
		 * correspondiendo a las columnas definidas por defecto la
		 */
		String informacion[][] = new String[listaBarcos.size()][titulosList.size()];
		
		for (int x = 0; x < informacion.length; x++) {
			
			informacion[x][Utilidades.COORD] = listaBarcos.get(x).getCoord()+ "";
			informacion[x][Utilidades.A1] = listaBarcos.get(x).getA1()+ "";
			informacion[x][Utilidades.A2] = listaBarcos.get(x).getA2()+ "";
			informacion[x][Utilidades.A3] = listaBarcos.get(x).getA3()+ "";
			informacion[x][Utilidades.A4] = listaBarcos.get(x).getA4()+ "";
			informacion[x][Utilidades.A5] = listaBarcos.get(x).getA5()+ "";
			informacion[x][Utilidades.A6] = listaBarcos.get(x).getA6()+ "";
			informacion[x][Utilidades.A7] = listaBarcos.get(x).getA7()+ "";
			informacion[x][Utilidades.A8] = listaBarcos.get(x).getA8()+ "";
			informacion[x][Utilidades.A9] = listaBarcos.get(x).getA9()+ "";
			
		}
		
		return informacion;
	}
	
	/**
	 * Con los titulos y la informaci�n a mostrar se crea el modelo para 
	 * poder personalizar la tabla, asignando tama�o de celdas tanto en ancho como en alto
	 * as� como los tipos de datos que va a poder soportar.
	 * @param titulos
	 * @param data
	 */
	private void construirTabla(String[] titulos, Object[][] data) {
		modelo=new ModeloTabla(data, titulos);
		//se asigna el modelo a la tabla
		tablaBattleShip.setModel(modelo);
		
		filasTabla=tablaBattleShip.getRowCount();
		columnasTabla=tablaBattleShip.getColumnCount();
		
		//se asigna el tipo de dato que tendr�n las celdas de cada columna definida respectivamente para validar su personalizaci�n
		tablaBattleShip.getColumnModel().getColumn(Utilidades.COORD).setCellRenderer(new GestionCeldas("numerico"));               
                tablaBattleShip.getColumnModel().getColumn(Utilidades.A1).setCellRenderer(new GestionCeldas("numerico"));
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A2).setCellRenderer(new GestionCeldas("numerico"));
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A3).setCellRenderer(new GestionCeldas("numerico"));
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A4).setCellRenderer(new GestionCeldas("numerico"));
                tablaBattleShip.getColumnModel().getColumn(Utilidades.A5).setCellRenderer(new GestionCeldas("numerico"));
                tablaBattleShip.getColumnModel().getColumn(Utilidades.A6).setCellRenderer(new GestionCeldas("numerico"));
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A7).setCellRenderer(new GestionCeldas("numerico"));
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A8).setCellRenderer(new GestionCeldas("numerico"));
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A9).setCellRenderer(new GestionCeldas("numerico"));
	
		tablaBattleShip.getTableHeader().setReorderingAllowed(false);
		tablaBattleShip.setRowHeight(25);//tama�o de las celdas
		tablaBattleShip.setGridColor(new java.awt.Color(0, 0, 0)); 
		//Se define el tama�o de largo para cada columna y su contenido
		tablaBattleShip.getColumnModel().getColumn(Utilidades.COORD).setPreferredWidth(80);//COORD
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A1).setPreferredWidth(80);//A1
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A2).setPreferredWidth(80);//A2
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A3).setPreferredWidth(80);//A3
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A4).setPreferredWidth(80);//A4
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A5).setPreferredWidth(80);//A5
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A6).setPreferredWidth(80);//A6
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A7).setPreferredWidth(80);//A7
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A8).setPreferredWidth(80);//A8
		tablaBattleShip.getColumnModel().getColumn(Utilidades.A9).setPreferredWidth(80);//A9
		
		//personaliza el encabezado
		JTableHeader jtableHeader = tablaBattleShip.getTableHeader();
	    jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
	    tablaBattleShip.setTableHeader(jtableHeader);
	    
	    //se asigna la tabla al scrollPane
	    scrollPaneTabla.setViewportView(tablaBattleShip);


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//capturo fila o columna dependiendo de mi necesidad
		int fila = tablaBattleShip.rowAtPoint(e.getPoint());
		int columna = tablaBattleShip.columnAtPoint(e.getPoint());
		
		/*uso la columna para valiar si corresponde a la columna de perfil garantizando
		 * que solo se produzca algo si selecciono una fila de esa columna
		 */
		if (columna==Utilidades.PERFIL) {
			//sabiendo que corresponde a la columna de perfil, envio la posicion de la fila seleccionada
			validarSeleccionMouse(fila);
		}else if (columna==Utilidades.EVENTO){//se valida que sea la columna del otro evento
			JOptionPane.showMessageDialog(null, "Evento del otro icono");
		}
		
	}

	/**
	 * Este metodo simularia el proceso o la acci�n que se quiere realizar si 
	 * se presiona alguno de los botones o iconos de la tabla
	 * @param fila
	 */
	private void validarSeleccionMouse(int fila) {
		Utilidades.filaSeleccionada=fila;
		
		
		//teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la informaci�n
		getValueCells miPersona=new getValueCells();

		String info="INFO CELDA\n";
		info+="Documento: "+miPersona.getA1()+"\n";
		info+="Nombre: "+miPersona.getA2()+"\n";
		
		JOptionPane.showMessageDialog(null, info);
	}

	
	//estos metododos pueden ser usados dependiendo de nuestra necesidad, por ejemplo para cambiar el tama�o del icono al ser presionado
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
