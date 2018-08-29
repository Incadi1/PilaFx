/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Data.Persona;
import Data.Valor;
import Modelo.Pila;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private MenuItem bSalir;
    @FXML
    private MenuItem bAgregar;
    @FXML
    private WebView web;

    private WebEngine engine;
    private Pila<Persona> p;
    private int contador;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        engine = web.getEngine();

        contador = 0;

        // Esta linea se escribe solo para que salga informacion al inicio del programa.
        engine.loadContent(Tools.convertirPilaAHtml(new Pila<>()));
    }

    /**
     * Metodo que permite asigar una pila desde la aplicacion.
     * @param p 
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: void setP(Pila<Valor>)">
    public void setP(Pila<Persona> p)
    {
        this.p = p;
    }
    //</editor-fold>

    /**
     * Metodo que permite salir de la aplicacion.
     * @param event 
     */
    @FXML
    //<editor-fold defaultstate="collapsed" desc="Metodo :: void handleButtonSalir(ActionEvent)">
    private void handleButtonSalir(ActionEvent event)
    {
        Platform.exit();
    }
//</editor-fold>
    
    /**
     * Metodo que permite invocar al metodo apilar para agregar informacion de una pila.
     * Además muestra la pila actualizada en la pantalla.
     * @param event 
     */
    @FXML
    //<editor-fold defaultstate="collapsed" desc="Metodo :: void handleButtonAgregar(ActionEvent)">
    private void handleButtonAgregar(ActionEvent event)
    {
        String texto = " --- " + contador + " --- ";
        contador++;
        p.apilar(new Persona(texto));
        
        engine.loadContent(Tools.convertirPilaAHtml(p));
        
        
    }
    //</editor-fold>

    /**
     * Metodo que permite invocar al metodo desapiar para retirar información de una pila.
     * Además muestra la pila actualizada en la pantalla.
     * @param event 
     */
    @FXML
    //<editor-fold defaultstate="collapsed" desc="Metodo :: void handleButtonRetirar(ActionEvent)">
    private void handleButtonRetirar(ActionEvent event)
    {
        if ( !p.estaVacio())
        {
            Persona e = p.desapilar();
            engine.loadContent(Tools.convertirPilaAHtml(p,e.getTexto()));
        }
        else
        {
            engine.loadContent(Tools.convertirPilaAHtml(p));
        }
    }
    //</editor-fold>

    
}
