package app;

import vista.frmPrincipal;

import javax.swing.*;

public class main {

	public static void main(String[] args) throws Exception {
		try {
			String operador = (String) JOptionPane.showInputDialog(null,
					"Ingrese nombre de Usuario:\n",
					"Login",
					JOptionPane.QUESTION_MESSAGE,
					null,
					null,
					"");

			if (!operador.isEmpty()) {
				frmPrincipal app = new frmPrincipal("Sociedades de Garantías Recíprocas (SGR) v1.9 - Operador: " + operador, operador);
				app.setVisible(true);
			}
		}
	    catch (Exception exception) {

		}
	}
	}
