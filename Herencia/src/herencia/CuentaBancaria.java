
package herencia;


import java.util.Calendar ;
public class CuentaBancaria {
     protected int numero;
    protected double saldo;
    protected String cliente;
    protected String moneda;
    protected TipoCuenta tipo;
    protected Calendar apertura;
     protected String[] historial = new String[50];
    protected int cantidadMovimientos = 0;    
    
   
  
    
     public CuentaBancaria ( int numero , String cliente , String moneda  ) {
        this.numero = numero ;
        this.cliente = cliente ;
        this.moneda = moneda ;
        this.saldo = 0 ;
        this. apertura=Calendar.getInstance();
       this.tipo = TipoCuenta.Cheques ;
       
        
     }
      public CuentaBancaria(int numero, String cliente, String moneda, TipoCuenta tipo) {
        this(numero, cliente, moneda);
        this.tipo = tipo;
    }
     
     public void depositar(double monto) {
        if (monto <= 0) {
            
            throw new IllegalArgumentException("El monto a depositar debe ser mayor que 0");
        }
        saldo += monto;
        registrarMovimiento("Deposito " + monto + "  saldo: " + saldo);
    }
      public boolean retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor que 0");
        }
        if (monto > saldo) {
            return false;
        }
        saldo -= monto;
        registrarMovimiento(" Retiro " + monto + "  saldo: " + saldo);
        return true;
    }
       protected void registrarMovimiento(String movimiento) {
        try {
            if (cantidadMovimientos >= historial.length) {
                throw new IllegalStateException("Historial lleno");
            }
            historial[cantidadMovimientos] = movimiento;
            cantidadMovimientos++;
        } catch (IllegalStateException e) {
            System.out.println("Anuncio: " + e.getMessage() + ", no se registró el movimiento");
        }
    }

     
     public void mostrarHistorial () {
         System.out.println("====== HISTORIAL DE " + cliente.toLowerCase()+ "=====");
         for (String registro : historial )
             System.out.println(registro);   
     }
      public double getSaldo()  {
          return saldo ;
      }     
      public String toString() {
         return String.format("Cuenta #%d | %s | $%.2f " , numero , cliente , saldo ) ;
         
      }
      public void transferencia (double monto , CuentaBancaria destino) {
         if(this.retirar(monto)) { 
           destino.depositar(monto)   ;
      
         
      }
         else {
             System.out.println("Trnasferencia fallida");
         }
      }
        
}


