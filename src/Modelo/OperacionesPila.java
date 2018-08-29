
package Modelo;


public class OperacionesPila<T extends Base> {
    
    /**
     * Este metodo es encargado de duplicar la información de una Pila
     * utilizando haciendo una copia profunda, que permita que los elementos de
     * la pila original y la copia sean independientes para no causar problemas
     * de borde.
     *
     * @param <T>
     * @param pilaOriginal Pila original
     * @return Pila Copiada
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Pila<T> duplicar(Pila<T>)">
    
    public static <T extends Base> Pila<T> duplicar (Pila<T> pilaOriginal) {
        Pila<T> pilaAux = new Pila<>();
        Pila<T> pilaCopia = new Pila<>();

        while (!pilaOriginal.estaVacio()) {
            pilaAux.apilar(pilaOriginal.desapilar());
        }

        while (!pilaAux.estaVacio()) {
            T e = pilaAux.desapilar();
            T c = (T) e.copy();
            pilaOriginal.apilar(e);
            pilaCopia.apilar(c);
        }

        return pilaCopia;
    }
    
    
     /**
     * Este metodo es encargado de invertir la información de una Pila
     * utilizando haciendo una copia profunda, que permita que los elementos de
     * la pila original y la copia sean independientes para no causar problemas
     * de borde.
     *
     * @param <T>
     * @param pilaOriginal Pila original
     * @return Pila Invertida
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Pila<T> invertir(Pila<T>)">
    public static <T extends Base> Pila<T> invertir(Pila<T> pilaOriginal) {
        Pila<T> pilaCopia = duplicar(pilaOriginal);
        Pila<T> pilaIntertida = new Pila<>();

        while (!pilaCopia.estaVacio()) {
            pilaIntertida.apilar(pilaCopia.desapilar());
        }

        return pilaIntertida;
    }
    
    
     public static <T extends Base> Pila<T> concatenar(Pila<T> pila1, Pila<T> pila2) {
        Pila<T> pilaAux1 = duplicar(pila1);
        Pila<T> pilaAux2 = invertir(pila2);

        while (!pilaAux2.estaVacio()) {
            pilaAux1.apilar(pilaAux2.desapilar());
        }

        return pilaAux1;
    }

    public static <T extends Base> Pila<T> mezclaMedia(Pila<T> pilaOriginal) {
        Pila<T> pilaCopia = invertir(pilaOriginal);
        Pila<T> pilaAux1 = new Pila<>();
        Pila<T> pilaAux2 = new Pila<>();

        while (!pilaCopia.estaVacio()) {
            pilaAux1.apilar(pilaCopia.desapilar());
            if (!pilaCopia.estaVacio()) {
                pilaAux2.apilar(pilaCopia.desapilar());
            }
        }

        return concatenar(pilaAux1, invertir(pilaAux2));
    }

    public static <T extends Base> Pila<T> pilaResult(Pila<T> pilaOriginal1, Pila<T> pilaOriginal2) {
        Pila<T> p1 = duplicar(pilaOriginal1);
        Pila<T> p2 = duplicar(pilaOriginal2);

        Pila<T> pinvertida2 = invertir(p2);
        Pila<T> pinvertida1 = invertir(p1);
        while (!pinvertida1.estaVacio()) {
            pinvertida2.apilar(pilaOriginal1.desapilar());
        }

        return pinvertida2;

    }

    public static <T extends Base> Pila<T> pilaResult2(Pila<T> pilaOriginal1, Pila<T> pilaOriginal2) {
        Pila<T> p1 = duplicar(pilaOriginal1);
        Pila<T> p2 = duplicar(pilaOriginal2);
        Pila<T> p2Invertir = invertir(p2);
        Pila<T> presult = new Pila<>();
        int cont = 0;
        while (!p1.estaVacio()) {
            if (cont % 2 == 0) {
                presult.apilar(p1.desapilar());
            } else {
                p1.desapilar();
            }
            cont++;
        }

        while (!p2Invertir.estaVacio()) {
            presult.apilar(p2Invertir.desapilar());
        }
        return presult;

    }
}
