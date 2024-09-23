package ejercicio2.controlador;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class GestorDeEjecuciones {

	public ArrayList<String> ejecutarComando(String comando) {
		ArrayList<String> infoProceso = new ArrayList<String>();
		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", comando);
		String salida = null;
		try {
			Process p = pb.start();
			ProcessHandle parentHandle = p.toHandle().parent().get();
			System.out.println("> Ejecutando " + comando);

			// Obtener el PID del proceso
			String pid = p.pid() + "";
			infoProceso.add(pid);

			String pidPadre = parentHandle.pid() + "";
			infoProceso.add(pidPadre);

			InputStream is = p.getInputStream();
			int c;
			salida = "";
			while ((c = is.read()) != -1) {
				salida += (char) c;
			}
			is.close();

			infoProceso.add(salida);

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		return infoProceso;
	}

	public ArrayList<String> ejecutarPrograma(String programa) {
		ArrayList<String> infoProceso = new ArrayList<String>();
		ProcessBuilder pb = new ProcessBuilder(programa);
		String salida = null;

		try {
			Process p = pb.start();
			ProcessHandle parentHandle = p.toHandle().parent().get();
			System.out.println("> Ejeutando programa " + programa);

			// Obtener el PID del proceso
			String pid = p.pid() + "";
			infoProceso.add(pid);

			String pidPadre = parentHandle.pid() + "";
			infoProceso.add(pidPadre);

			InputStream is = p.getInputStream();
			int c;
			salida = "";
			while ((c = is.read()) != -1) {
				salida += (char) c;
			}
			is.close();

			infoProceso.add(salida);

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		return infoProceso;
	}

	public ArrayList<String> ejecutarEjer7(String texto) {
		ArrayList<String> infoProceso = new ArrayList<String>();
		// Ajusta el classpath y la ruta de la clase Ejer7
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "src", "ejercicio1.ejercicio7.Ejer7");
		String salida = null;
		
		pb.redirectErrorStream(true);

		try {
			Process p = pb.start();
			// Obtener el proceso del padre
			ProcessHandle parentHandle = p.toHandle().parent().get();
			System.out.println("> Ejeutando Ejer7 con el argumento " + texto);

			OutputStream os = p.getOutputStream();
			byte[] textoBytes = (texto + System.lineSeparator()).getBytes();
			os.write(textoBytes);
			os.flush();
			os.close();

			// Obtener el PID del proceso
			String pid = p.pid() + "";
			infoProceso.add(pid);

			String pidPadre = parentHandle.pid() + "";
			infoProceso.add(pidPadre);

			InputStream is = p.getInputStream();
			int c;
			salida = "";
			while ((c = is.read()) != -1) {
				salida += (char) c;
			}
			is.close();

			infoProceso.add(salida);

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		return infoProceso;
	}

}
