/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.corsi;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Divisione;
import it.polito.tdp.corsi.model.Model;
import it.polito.tdp.corsi.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtPeriodo"
    private TextField txtPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorso"
    private TextField txtCorso; // Value injected by FXMLLoader

    @FXML // fx:id="btnCorsiPerPeriodo"
    private Button btnCorsiPerPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="btnNumeroStudenti"
    private Button btnNumeroStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="btnStudenti"
    private Button btnStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="btnDivisioneStudenti"
    private Button btnDivisioneStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML
    void corsiPerPeriodo(ActionEvent event) {
    	txtRisultato.clear();
    	String periodo = txtPeriodo.getText();
    	int periodoNumerico;
    	
    	try {
    		periodoNumerico= Integer.parseInt(periodo);
    	} catch (NumberFormatException e) {
    		txtRisultato.setText("Inserisci un periodo numerico!");
    		e.printStackTrace();
    		return; //IMPORTANTE
    	}
    	
    	if(periodoNumerico<1 || periodoNumerico>2) {
    		txtRisultato.setText("Inserisci 1 o 2!");
    	}
    	
    	List<Corso> corsi = this.model.getCorsiByPeriodo(periodoNumerico);
    	for(Corso ci : corsi) {
    		txtRisultato.appendText(ci+"\n");
    	}
    	
    }

    @FXML
    void numeroStudenti(ActionEvent event) {
    	txtRisultato.clear();
    	String periodo = txtPeriodo.getText();
    	int periodoNumerico;
    	
    	try {
    		periodoNumerico= Integer.parseInt(periodo);
    	} catch (NumberFormatException e) {
    		txtRisultato.setText("Inserisci un periodo numerico!");
    		e.printStackTrace();
    		return; //IMPORTANTE
    	}
    	
    	if(periodoNumerico<1 || periodoNumerico>2) {
    		txtRisultato.setText("Inserisci 1 o 2!");
    	}
    	
    	Map<Corso,Integer> iscritti = this.model.getIscritti(periodoNumerico);
    	for(Corso ci : iscritti.keySet()) {
    		txtRisultato.appendText(ci + " " + iscritti.get(ci)+ "\n");
    	}
    	
    }

    @FXML
    void stampaDivisione(ActionEvent event) {
    	
    	String codins = txtCorso.getText();
    	
    	if(codins == null || codins.compareTo("")==0) {
    		txtRisultato.appendText("Perfavore inserisci un codice di un corso!");
    		return;
    	}
    	
    	//TODO Controllo che il corso esista
    	
    	List<Divisione> ris = this.model.getDivisioneStudenti(codins);
    	
    	Collections.sort(ris);
    	
    	for(Divisione di: ris) {
    		txtRisultato.appendText(di.toString()+"\n");
    	}
    	
    }

    @FXML
    void stampaStudenti(ActionEvent event) {
    	
    	String codins = txtCorso.getText();
    	
    	if(codins == null || codins.compareTo("")==0) {
    		txtRisultato.appendText("Perfavore inserisci un codice di un corso!");
    		return;
    	}
    	
    	//TODO Controllo che il corso esista
    	
    	for(Studente si: this.model.getStudentiByCorso(codins)) {
    		txtRisultato.appendText(si.toString()+"\n");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCorsiPerPeriodo != null : "fx:id=\"btnCorsiPerPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnNumeroStudenti != null : "fx:id=\"btnNumeroStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStudenti != null : "fx:id=\"btnStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDivisioneStudenti != null : "fx:id=\"btnDivisioneStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
    
    
}