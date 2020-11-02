
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author - Elorri Oloritz
 *  
 */
public class HojaCalculo
{
    private String nombre;
    private Fila fila1;
    private Fila fila2;
    private Fila fila3;

    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre)    {
        this.nombre = nombre;
        this.fila1 = null;
        this.fila2 = null;
        this.fila3 = null;

    }

    /**
     * accesor para el nombre de la hoja
     */
    public String getNombre() {
        return this.nombre;

    }

    /**
     * accesor para la fila1
     */
    public Fila getFila1() {
        return fila1;

    }

    /**
     * accesor para la fila2
     */
    public Fila getFila2() {
        return fila2;

    }

    /**
     * accesor para la fila3
     */
    public Fila getFila3() {
        return fila3;

    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int filas = 0;
        if (fila1 != null){
            filas++;
        }
        if (fila2 != null){
            filas++;
        }
        if (fila3 != null){
            filas++;
        }
        return filas;

    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if (getNumeroFilas() == 3){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if (getNumeroFilas() < 3){
            if (fila1 == null){
                fila1 = fila;
            }
            else if (fila2 == null){
                fila2 = fila;
            }
            else if (fila3 == null){
                fila3 = fila;
            }
        }
        else {
            System.out.println(fila.getId() + "no se puede añadir en " + nombre);
        }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila fila = new Fila(id,fecha,ingresos,gastos);
        addFila(fila);
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double totalIngresos = 0;
        if (getNumeroFilas() > 1 && getNumeroFilas() < 4){
            totalIngresos += fila2.getIngresos();
        }
        if (getNumeroFilas() > 2 && getNumeroFilas() < 4){
            totalIngresos += fila3.getIngresos();
        }
        if (getNumeroFilas() < 4 && getNumeroFilas() > 0){
            totalIngresos += fila1.getIngresos();
        }
        return totalIngresos;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double totalGastos = 0;
        if (getNumeroFilas() > 1 && getNumeroFilas() < 4){
            totalGastos += fila2.getGastos();
        }
        if (getNumeroFilas() > 2 && getNumeroFilas() < 4){
            totalGastos += fila3.getGastos();
        }
        if (getNumeroFilas() < 4 && getNumeroFilas() > 0){
            totalGastos += fila1.getGastos();
        }
        return totalGastos;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double beneficio = 0;
        if (getNumeroFilas() > 1 && getNumeroFilas() < 4){
            beneficio += fila2.getBeneficio();
        }
        if (getNumeroFilas() > 2 && getNumeroFilas() < 4){
            beneficio += fila3.getBeneficio();
        }
        if (getNumeroFilas() < 4 && getNumeroFilas() > 0){
            beneficio += fila1.getBeneficio();
        }
        return beneficio;
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String filaUno = "";
        String filaDos = "";
        String filaTres = "";

        if (getNumeroFilas() > 1 && getNumeroFilas() < 4){
            filaDos = fila2.toString();
        }
        if (getNumeroFilas() > 2 && getNumeroFilas() < 4){
            filaTres = fila3.toString();
        }
        if (getNumeroFilas() < 4 && getNumeroFilas() > 0){
            filaUno = fila1.toString();
        }

        String sfm1 = String.format("%8s\n", nombre);
        String sfm2 = String.format("%8s %15s %15s %15s %15s %2s\n","", "FECHA",
                "INGRESOS", "GASTOS", "BENEFICIO", "");
        String sfm3 = filaUno + "\n";
        String sfm4 = filaDos + "\n";
        String sfm5 = filaTres + "\n";
        String sfm6 = String.format("---------------------------------------------------------------------------\n");
        String sfm7 = String.format("%8s %15s %15.2f€ %15.2f€ %15.2f€ %2s\n", "", "",
            getTotalIngresos(), getTotalGastos(), getBeneficio(), "");

        return (sfm1 + sfm2 + sfm3 + sfm4 + sfm5 + sfm6 + sfm7);
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo clon = new HojaCalculo("Duplicada " + nombre);
        clon.fila1 = fila1;
        clon.fila2 = fila2;
        clon.fila3 = fila3;
        return clon;
    }

}
