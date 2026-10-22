
package herencia;
import java.util.Calendar ;

public class CuentaAhorro extends  CuentaBancaria {
    private Calendar ultimoUso;
   
    public CuentaAhorro(int numero, String cliente, String moneda) {
        super(numero, cliente, moneda, TipoCuenta.Ahorro);
        ultimoUso = Calendar.getInstance();
    }
    // si esta activa la cuenta
     public boolean estaActiva() {
        Calendar limite = Calendar.getInstance();
        limite.add(Calendar.MONTH, -6);
        return ultimoUso.after(limite);
    }
    @Override
      
       public void depositar(double monto) {
        if (estaActiva() == false) {
            throw new IllegalStateException("La cuenta de ahorro está inactiva");
        }
        super.depositar(monto);
        ultimoUso = Calendar.getInstance();
    }
    

     public boolean retirar(double monto) {
        if (estaActiva() == false) {
            throw new IllegalStateException("La cuenta de ahorro está inactiva");
        }
        boolean Retiro = super.retirar(monto);
        if (Retiro) {
            ultimoUso = Calendar.getInstance();
        }
        return Retiro;
    }
    
     }


