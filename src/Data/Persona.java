
package Data;

import Modelo.Base;

public class Persona extends Base{
 private String texto;

    public Persona(String texto)
    {
        this.texto = texto;
    }

   
    public String getTexto()
    {
        return texto;
    }

  
    public void setTexto(String texto)
    {
        this.texto = texto;
    }

    @Override
    public String toString()
    {
        return texto;
    }

    @Override
    public Base copy()
    {
        return new Persona(texto);
    }
}
