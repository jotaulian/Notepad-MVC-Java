package es.studium.MiBloc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModeloFichero
{
	public ModeloFichero(){}
	
		//CargarFichero
		public String cargarFichero(String ruta) {
			String contenido = "";
			try
			{
				FileReader fr = new FileReader(ruta);
				BufferedReader entrada = new BufferedReader(fr);
				String s;
				
				while((s=entrada.readLine())!=null)
				{
					contenido = contenido + s + "\n";
				}
				entrada.close();
				fr.close();
			}
			catch(IOException i){}
			return contenido;
		}
		
		// Guardar Fichero
		public void guardarFichero(String ruta, String mensaje) {
			try
			{
				FileWriter fw = new FileWriter(ruta);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter salida = new PrintWriter(bw);
				salida.println(mensaje);
				salida.close();
				bw.close();
				fw.close();
			}
			catch(IOException i){}
			
		}
		
		//Contar Palabras
		public int contarPalabras(String cadena) {
			int cantidad = 0;
			for (int i = 0; i < cadena.length(); i++) {
				if (cadena.charAt(i)==' ' || cadena.charAt(i)=='\n' ) {
					cantidad++;
				}
			}
			//cantidad++; 
			return cantidad; 
		}

		//Contar Letras
		public int contarLetras(String cadena)
		{
			int letras = 0;
			Pattern patron;
			Matcher matcher;
			patron = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚ]");
			for (int i = 0; i < cadena.length(); i++) {
				matcher = patron.matcher(cadena.charAt(i)+"");
				if(matcher.matches()) {
					letras++;
				}
			}
			return letras;
		}
		
		//Contar Vocales
		public int contarVocales(String cadena)
		{
			int vocales = 0;
			Pattern patron;
			Matcher matcher;
			patron = Pattern.compile("[aeiouAEIOUáéíóúÁÉÍÓÚ]");
			for (int i = 0; i < cadena.length(); i++) {
				matcher = patron.matcher(cadena.charAt(i)+"");
				if(matcher.matches()) {
					vocales++;
				}
			}
			return vocales;
		}
}