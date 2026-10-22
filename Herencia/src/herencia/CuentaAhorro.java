
package herencia;
import java.util.Calendar ;

public class CuentaAhorro {
    private Calendar ultimaModif ;
    private int retirosRealizados = 0 ;
    private static final int Max_Retiros_=3 ;
  public CuentaAhorro(int cuenta, String cliente) {
    super(cuenta, cliente,  0.03 );
    this.ultimaModif = Calendar.getInstance() ;
    }  
    public boolean status () {
     Calendar FechaActual = Calendar.getInstance() ;
     FechaActual.add(Calendar.MONTH ,-6) ;
     return ultimaModif.after(FechaActual) ;
     
    }
     public void aplicarInterese () {
         if(status ()) {
             double interes = saldo*tasa ;
             depositar(interes) ;
             historial.add("Interese aplicados :" + interes) ;
             
         }
         // retiro  verificar retiro comprobar cuantos retiros 
     }
     }

}
