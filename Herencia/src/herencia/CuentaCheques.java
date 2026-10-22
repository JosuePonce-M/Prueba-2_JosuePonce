
package herencia;


public class CuentaCheques extends CuentaBancaria {
    private double limiteSobregiro;

 public CuentaCheques(int numero, String cliente, String moneda, double limiteSobregiro) {
        super(numero, cliente, moneda, TipoCuenta.Cheques);
        if (limiteSobregiro < 0) {
            throw new IllegalArgumentException("El límite de sobregiro no puede ser negativo");
        }
        this.limiteSobregiro = limiteSobregiro;
    }
  public void girarCheque(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del cheque debe ser mayor que 0");
        }
        if (monto > saldo + limiteSobregiro) {
            throw new IllegalStateException("Fondos insuficientes para girar el cheque");
        }
        saldo -= monto;
        registrarMovimiento(" cheque" + monto + "  saldo: " + saldo);
    }
  // metodo 
  public double sobregiroDisponible() {
        if (saldo >= 0) {
            return limiteSobregiro;
        }
        return limiteSobregiro + saldo;
    }
  @Override
    public void quienSoy() {
        System.out.println(" una de CuentaCheques");
    }

    @Override
    public String toString() {
        return super.toString() + " Sobregiro disponible: " + sobregiroDisponible();
    }
  
}


