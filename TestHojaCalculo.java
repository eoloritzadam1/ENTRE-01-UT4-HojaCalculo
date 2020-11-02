
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - Elorri Oloritz
 *  
 */
public class TestHojaCalculo
{

    /**
     * Constructor  
     */
    public TestHojaCalculo()    {

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podrá guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1() {
         HojaCalculo hoja = new HojaCalculo("HOJA1");
         hoja.addFila("Fila1", new Fecha(4,10,2020), 25.5, 132.0);
         hoja.addFila("Fila2", new Fecha(5,10,2020), 300.0, 350.0);
         hoja.addFila("Fila3", new Fecha(1,1,2020), 0, 0);
         Fila fila4 = new Fila("Fila4");
         
         System.out.println(hoja.toString());
         System.out.println(hoja.duplicarHoja());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
         HojaCalculo hoja = new HojaCalculo("HOJA2");
         hoja.addFila("Fila1", new Fecha(7,10,2020), 260.0, 125.0);
         hoja.addFila("Fila2", new Fecha(8,10,2020), 125.0, 245.0);
         
         System.out.println(hoja.toString());
         System.out.println(hoja.duplicarHoja());

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
         HojaCalculo hoja = new HojaCalculo("HOJA2");
         hoja.addFila("Fila1", new Fecha(8,10,2020), 670.0, 234.0);
         
         System.out.println(hoja.toString());
         System.out.println(hoja.duplicarHoja());
            

    }

}
