import javax.swing.JOptionPane;

public class Procesos {
    String[] nombres;
    double[] imc;
    double peso, talla;
    String categoria;

    public Procesos() {
        int cantidadPersonas = obtenerCantidadPersonas();
        nombres = new String[cantidadPersonas];
        imc = new double[cantidadPersonas];
        llenarDatos();
        evaluarIMC();
        mostrarResultados();
    }

    private int obtenerCantidadPersonas() {
        int cantidad = 0;
        cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de personas que desea evaluar", "Cantidad de Personas", JOptionPane.PLAIN_MESSAGE));
        return cantidad;
    }

    private void llenarDatos() {
        for (int i = 0; i < nombres.length; i++) {
            nombres[i] = JOptionPane.showInputDialog(null, "Ingrese el nombre de la persona " + (i + 1), "Nombre", JOptionPane.PLAIN_MESSAGE);
            peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el peso de " + nombres[i] + " (en kg)", "Peso", JOptionPane.PLAIN_MESSAGE));
            talla = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la talla de " + nombres[i] + " (en metros)", "Talla", JOptionPane.PLAIN_MESSAGE));
            double indiceMasaCorporal = calcularIMC(peso, talla);
            imc[i] = indiceMasaCorporal;
        }
    }

    private double calcularIMC(double peso, double talla) {
        return peso / (talla * talla);
    }

    private void evaluarIMC() {
        for (int i = 0; i < nombres.length; i++) {
            if (imc[i] >= 40) {
                categoria = "Obesidad Mórbida";
            } else if (imc[i] >= 35) {
                categoria = "Obesidad grado 3";
            } else if (imc[i] >= 30) {
                categoria = "Obesidad grado 2";
            } else if (imc[i] >= 27) {
                categoria = "Obesidad grado 1";
            } else if (imc[i] >= 20) {
                categoria = "Normalidad";
            } else if (imc[i] >= 18) {
                categoria = "Delgadez";
            } else {
                categoria = "Anorexia";
            }
        }
    }

    private void mostrarResultados() {
        String resultados = "";
        for (int i = 0; i < nombres.length; i++) {
            resultados += "Nombre: " + nombres[i] + "\n";
            resultados += "IMC: " + imc[i] + "\n";
            resultados += "Categoría: " + categoria + "\n";
            resultados += "--------------------\n";
        }

        JOptionPane.showMessageDialog(null, resultados, "Resultados IMC", JOptionPane.INFORMATION_MESSAGE);
    }
}
