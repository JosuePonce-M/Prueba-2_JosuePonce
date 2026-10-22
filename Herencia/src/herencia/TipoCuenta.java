
package herencia;


public class TipoCuenta {
   private  String nombre;
    private  double tasa;

    private TipoCuenta(String nombre, double tasa) {
        this.nombre = nombre;
        this.tasa = tasa;
    }
    public static final TipoCuenta Ahorro  = new TipoCuenta("AHORRO", 0.03);
    public static final TipoCuenta Cheques = new TipoCuenta("CHEQUES", 0.00);
    public static final TipoCuenta Plazo  = new TipoCuenta("PLAZO", 0.05);
        public double tasa() {
        return tasa;
    }
        public String toString() {
            return nombre ;
        }
}
