package es.studium.MiBloc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class ControladorFichero implements ActionListener, WindowListener
{
	VistaFichero vistaFichero;
	ModeloFichero modeloFichero;

	public ControladorFichero(VistaFichero vf, ModeloFichero mf)
	{
		vistaFichero = vf;
		modeloFichero = mf;

		vistaFichero.ventana.addWindowListener(this);
		vistaFichero.miArchivoNuevo.addActionListener(this);
		vistaFichero.miArchivoAbrir.addActionListener(this);
		vistaFichero.miArchivoGuardar.addActionListener(this);
		vistaFichero.miArchivoSalir.addActionListener(this);
		
		vistaFichero.miGestionPalabras.addActionListener(this);
		vistaFichero.miGestionLetras.addActionListener(this);
		vistaFichero.miGestionVocales.addActionListener(this);
		
		vistaFichero.dlgMensajes.addWindowListener(this);
	}

	@Override
	public void windowActivated(WindowEvent arg0){}

	@Override
	public void windowClosed(WindowEvent arg0){}

	@Override
	public void windowClosing(WindowEvent arg0)
	{
		if(vistaFichero.dlgMensajes.isActive())
		{
			vistaFichero.dlgMensajes.setVisible(false);
		}
		else
		{
			System.exit(0);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0){}

	@Override
	public void windowDeiconified(WindowEvent arg0){}

	@Override
	public void windowIconified(WindowEvent arg0){}

	@Override
	public void windowOpened(WindowEvent arg0){}

	//ACTION PERFORMED METHOD
	@Override
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource().equals(vistaFichero.miArchivoSalir))
		{
			System.exit(0);
		}
		else if(evento.getSource().equals(vistaFichero.miArchivoNuevo))
		{
			vistaFichero.txaTexto.selectAll();
			vistaFichero.txaTexto.setText("");
		}
		else if(evento.getSource().equals(vistaFichero.miArchivoAbrir))
		{
			String contenido;
			vistaFichero.fdAbrir.setVisible(true);
			contenido = modeloFichero.cargarFichero(vistaFichero.fdAbrir.getDirectory()+""+vistaFichero.fdAbrir.getFile());
			vistaFichero.txaTexto.selectAll();
			vistaFichero.txaTexto.setText(contenido);
			
		} 
		else if(evento.getSource().equals(vistaFichero.miArchivoGuardar))
		{
			String mensaje = vistaFichero.txaTexto.getText();
			vistaFichero.fdGuardar.setVisible(true);
			modeloFichero.guardarFichero(vistaFichero.fdGuardar.getDirectory()+""+vistaFichero.fdGuardar.getFile(), mensaje);
		} 
		else if(evento.getSource().equals(vistaFichero.miGestionPalabras)){
			String cadena = vistaFichero.txaTexto.getText();
			int cantidad = modeloFichero.contarPalabras(cadena);
			vistaFichero.lblMensaje.setText("Hay " + cantidad + " palabras en el texto.");
			vistaFichero.dlgMensajes.setVisible(true);
			
		}
		else if(evento.getSource().equals(vistaFichero.miGestionLetras)){
			String cadena = vistaFichero.txaTexto.getText();
			int cantidad = modeloFichero.contarLetras(cadena);
			vistaFichero.lblMensaje.setText("Hay " + cantidad + " letras en el texto.");
			vistaFichero.dlgMensajes.setVisible(true);
			
		}
		else if(evento.getSource().equals(vistaFichero.miGestionVocales)){
			String cadena = vistaFichero.txaTexto.getText();
			int cantidad = modeloFichero.contarVocales(cadena);
			vistaFichero.lblMensaje.setText("Hay " + cantidad + " vocales en el texto.");
			vistaFichero.dlgMensajes.setVisible(true);
			
		}
	}
	
}
