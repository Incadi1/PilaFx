
package Data;

import Modelo.Base;

public class Valor extends Base{

    private int numero;

    public Valor() {
    }

    public Valor(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public Base copy() {
        return new Valor(numero);
    }

    @Override
    public String toString() {
        return ""+numero ;
    }
}
