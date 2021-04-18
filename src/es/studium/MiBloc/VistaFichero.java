package es.studium.MiBloc;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

public class VistaFichero
{
	Frame ventana = new Frame("MiBloc");
	Dialog dlgMensajes = new Dialog(ventana, "Mensaje", true);
	
	MenuBar menuBar = new MenuBar();

	Menu mArchivo = new Menu("Archivo");
	MenuItem miArchivoNuevo = new MenuItem("Nuevo");
	MenuItem miArchivoAbrir = new MenuItem("Abrir");
	MenuItem miArchivoGuardar = new MenuItem("Guardar");
	MenuItem miArchivoSalir = new MenuItem("Salir");
	
	Menu mGestion = new Menu("Gestión");
	MenuItem miGestionPalabras = new MenuItem("Contar Palabras");
	MenuItem miGestionLetras = new MenuItem("Contar Letras");
	MenuItem miGestionVocales = new MenuItem("Contar Vocales");
	
	TextArea txaTexto = new TextArea(20,43);
	Label lblMensaje = new Label("Archivo no Encontrado");
	
	FileDialog fdAbrir = new FileDialog(ventana, "Seleccionar archivo", FileDialog.LOAD);
	FileDialog fdGuardar = new FileDialog(ventana, "Seleccionar archivo", FileDialog.SAVE);
	
	public VistaFichero()
	{
		
		mArchivo.add(miArchivoNuevo);
		mArchivo.add(miArchivoAbrir);
		mArchivo.add(miArchivoGuardar);
		mArchivo.addSeparator();
		mArchivo.add(miArchivoSalir);
		menuBar.add(mArchivo);
		
		mGestion.add(miGestionPalabras);
		mGestion.add(miGestionLetras);
		mGestion.add(miGestionVocales);
		menuBar.add(mGestion);
		
		ventana.setMenuBar(menuBar);
		ventana.add(txaTexto);
		ventana.setSize(380,370);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		dlgMensajes.setLayout(new FlowLayout());
		dlgMensajes.setSize(180,100);
		dlgMensajes.setResizable(false);
		dlgMensajes.setLocationRelativeTo(null);
		dlgMensajes.add(lblMensaje);
		
	}
}
