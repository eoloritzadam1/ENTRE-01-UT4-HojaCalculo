
/**
 *  Representa a una fila de la hoja de cálculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @author - Elorri Oloritz
 *  
 */
public class Fila
{
    private String id;
    private Fecha fecha;
    private double ingresos;
    private double gastos;

    /**
     * Constructor 1 
     */
    public Fila(String id)    {
         this.id = id;
         ingresos = 0;
         gastos = 0;
         fecha.setAño(2000);
         fecha.setMes(1);
         fecha.setDia(1);
    }

    /**
     * Constructor 2 
     */
    public Fila(String id, Fecha fecha, double ingresos, double gastos)    {
        this.id = id;
        this.fecha = fecha;
        this.ingresos = ingresos;
        this.gastos = gastos;
        

    }
    
    /**
     * accesor para el id de la fila
     */
    public String getId() {
        return this.id;

    }


    /**
     * accesor para la fecha
     */
    public Fecha getFecha() {
        return this.fecha;

    }

    /**
     * accesor para los ingresos
     */
    public double getIngresos() {
        return this.ingresos;

    }

    /**
     * accesor para los gastos
     */
    public double getGastos() {
        return this.gastos;

    }

    /**
     * calcula y devuelve el beneficio
     */
    public double getBeneficio() {
        return this.ingresos - this.gastos;

    }
    
    /**
     * obtiene una copia idéntica a la fila actual.
     * La fecha que incluye la fila duplicada también es una copia
     * 
     */
    public Fila duplicar() {
       Fila duplicar = new Fila(id,fecha,ingresos,gastos);
       return duplicar;

    }

    /**
     * Representación textual de una fila
     * (leer enunciado)
     */
    public String toString() {
        String formato = "";
        formato = String.format("%8s, %15d, %15.2d€, %15.2d€, %15.2d€",
        "Fila1", fecha, ingresos, gastos, getBeneficio());
        return formato;
    }

     

}
