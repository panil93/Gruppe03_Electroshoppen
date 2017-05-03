/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import gruppe03_electroshoppen.Kunde;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button; 
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import gruppe03_electroshoppen.Mediator;
import gruppe03_electroshoppen.Order;
import gruppe03_electroshoppen.Produkt;
import gruppe03_electroshoppen.Varer;
import java.util.Calendar;
import java.util.List;
import javafx.scene.control.ListView;
import javafx.scene.control.SpinnerValueFactory;

/**
 * FXML Controller class
 *
 * @author Laura
 */
public class MenuFXMLController implements Initializable {

    private Mediator mediator;
    @FXML
    AnchorPane shopPane;
    @FXML
    AnchorPane medarbejderPane;
    @FXML
    AnchorPane loggingPane;
    @FXML
    AnchorPane registerPane;
    @FXML
    AnchorPane kassePane;
    @FXML
    AnchorPane kampagnePane;
    @FXML
    AnchorPane kundekontoPane;
    @FXML
    AnchorPane udlevendørePane;
    @FXML
    Button logpaa;
    @FXML
    Button logaf;
    @FXML
    Button kundekonto;
    @FXML
    Button register;
    @FXML
    Button soueg;
    @FXML
    Button addtocart;
    @FXML
    Button removefromcart;
    @FXML
    Pane soegpane;
    @FXML
    Button gaatilkassen;
    @FXML
    Label totalLabel;
    @FXML
    Button tilbage0;
    @FXML
    Button tilbage1;
    @FXML
    Button tilbage2;
    @FXML
    Button tilbage3;
    @FXML
    Button kunde;
    @FXML
    Button medarbejder;
    @FXML
    Button under;
    @FXML
    Button kamp;
    @FXML
    TextField loginek;
    @FXML
    TextField password;
    @FXML
    TextField regname;
    @FXML
    TextField regaddr;
    @FXML
    TextField regtel;
    @FXML
    TextField reglog;
    @FXML
    TextField redadg;
    @FXML
    Button regslut;
    @FXML
    ToggleGroup group;
    @FXML
    RadioButton kat;
    @FXML
    RadioButton id;
    @FXML
    TextField søgid;
    @FXML
    ListView søgkat;
    @FXML
    Label katlab;
    @FXML
    Button søgslut;
    @FXML
    Button tilbage4;
    @FXML
    ListView undlist;
    @FXML
    ListView unddet;
    @FXML
    Button undmak;
    @FXML
    Button undan;
    @FXML
    ToggleGroup hente;
    @FXML
    RadioButton hjem;
    @FXML
    RadioButton collect;
    @FXML
    TextArea order;
    @FXML
    TextField totalpris;
    @FXML
    TextField procent;
    @FXML
    Button bet;
    @FXML
    Pane collectPane;
    @FXML
    ListView listButikker;
    @FXML
    Button chooseButton;
    @FXML
    Button nykamp;
    @FXML
    Button logaff;
    @FXML
    Pane nykampPane;
    @FXML
    ToggleGroup kamptog;
    @FXML
    RadioButton web;
    @FXML
    RadioButton pos;
    @FXML
    RadioButton begge;
    @FXML
    Spinner rabat;
    @FXML
    DatePicker stardate;
    @FXML
    DatePicker slutdate;
    @FXML
    Button opretbutton;
    @FXML
    Button nyreklam;
    @FXML
    Button redigopl;
    @FXML
    Button logafff;
    @FXML
    ListView kundereklam;
    @FXML
    TextArea kundeoplys;
    @FXML
    ListView kundeorderer;
    @FXML
    TextField kundetilbud;
    @FXML
    Pane reklampane;
    @FXML
    ListView reklamord;
    @FXML
    TextField reklamaars;
    @FXML
    ListView reklamprod;
    @FXML
    TextField reklamlist;
    ToggleGroup reklamationer;
    @FXML
    RadioButton penge;
    @FXML
    RadioButton varer;
    @FXML
    Button opretreklam;
    @FXML
    Pane redigeringsPane;
    @FXML
    Button skiftbutton;
    @FXML
    Button gemoplys;
    @FXML
    TextField redigname;
    @FXML
    TextField redigadd;
    @FXML
    TextField redigtel;
    @FXML
    TextField rediggampass;
    @FXML
    TextField redignypass;
    @FXML
    Button infobutton;
    @FXML
    Button markmed;
    @FXML
    Button logaffff;
    @FXML
    TextField pakkeoplys;
    @FXML
    TextField pakkemodtag;
    @FXML
    TextField pakkedetaj;
    @FXML
    ListView<Varer> katalog;
    @FXML
    ListView<Varer> cart;
    @FXML
    Label formedarb;
    @FXML
    Label regerrorlabel;
    @FXML
    Label kunneik;
    @FXML
    ListView banner;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleMedarbejderAction(ActionEvent event) {
        Button pressed_button = (Button) event.getSource();
        if (pressed_button == logaffff) {
            medarbejderPane.setVisible(false);
            shopPane.setVisible(true);
        }

    }

    @FXML
    private void handleKampagneAction(ActionEvent event) {
        Button pressed_button = (Button) event.getSource();
        if (pressed_button == logaff) {
            kampagnePane.setVisible(false);
            shopPane.setVisible(true);
            register.setVisible(true);
            logpaa.setVisible(true);
            kundekonto.setVisible(false);
            logaf.setVisible(false);

        } else if (pressed_button == nykamp) {
            nykampPane.setVisible(true);
        } else if (pressed_button == opretbutton) {
            this.handleKampagnePaneAction(event);
        }
    }

    @FXML
    private void handleKampagnePaneAction(ActionEvent event) {
        double newPrice = 0;
        
        RadioButton radiusek = (RadioButton) kamptog.getSelectedToggle();
        if (radiusek == web) {
            List<Varer> tester = mediator.getListOfVarer();
            for (Varer v : mediator.getListOfVarer()) {
                if (v instanceof Produkt) {
                    newPrice=((Produkt) v).calculatePriceWithRabat((Integer)rabat.getValue(), v.getPris());
                    
                    v.setPris(newPrice);
                    formedarb.setText("Du har opretter kampagne med " + rabat.getValue() + "% rabat i Webshoppen");
                    if (Calendar.getInstance().after(stardate.getValue())&&Calendar.getInstance().before(slutdate.getValue())){
           banner.getItems().add("Vild tilbud! hele "+rabat.getValue()+"% kun i Webshoppen");
                    }
                   
                }

                
            } 

        } else if (radiusek == pos) {
            formedarb.setText("Du har opretter kampagne med " + rabat.getValue() + "% rabat i Points of Sale");
           if (Calendar.getInstance().after(stardate.getValue())&&Calendar.getInstance().before(slutdate.getValue())){
           banner.getItems().add("Vild tilbud! hele "+rabat.getValue()+"% kun i POS");
           }
           
        } else if (radiusek == begge) {
            for (Varer v : mediator.getListOfVarer()) {
                double d = v.getPris();
                newPrice = (d * (1 - (Integer) rabat.getValue() / 100));
                v.setPris(newPrice);

                formedarb.setText("Du har opretter kampagne med " + rabat.getValue() + "% rabat i både Webshoppen og Points of Sale");
          if (Calendar.getInstance().after(stardate.getValue())&&Calendar.getInstance().before(slutdate.getValue())){
           banner.getItems().add("Vild tilbud! hele "+rabat.getValue()+"% kun i Electroshoppen");
           }
            }

        }
        updateKatalog();
    }

    @FXML
    private void handleKasseAction(ActionEvent event) {
        RadioButton radiusek = (RadioButton) group.getSelectedToggle();
        if (radiusek == hjem) {

        } else if (radiusek == collect) {
            collectPane.setVisible(true);

        }
    }

    @FXML

    private void handleKundeKontoAction(ActionEvent event) {
        Button pressed_button = (Button) event.getSource();
        if (pressed_button == nyreklam) {
            reklampane.setVisible(true);

        } else if (pressed_button == logafff) {
            kundekontoPane.setVisible(false);
            shopPane.setVisible(true);
            kundeoplys.clear();
            kundeorderer.getItems().clear();
            logpaa.setVisible(true);
            register.setVisible(true);
            kundekonto.setVisible(false); 
            logaf.setVisible(false);
        } else if (pressed_button == redigopl) {
            kunneik.setText(" ");
            kundeoplys.setVisible(false);
            kundeorderer.setVisible(false);
            redigeringsPane.setVisible(true);
        }
            else if (pressed_button == gemoplys) {
                Order orde;
                
                redigeringsPane.setVisible(false);
           for( Kunde kundas: mediator.getListOfKunder()){
            if(kundas.toString().compareTo(kundeoplys.getText())==0){
            
                    
                
                if((redignypass.getText().isEmpty()==false)&&(rediggampass.getText().compareTo(kundas.getAdgangskode()))==0){
                  kundas.setAdgangskode(redignypass.getText());
                  rediggampass.setVisible(false);
                  redignypass.setVisible(false);
                  updateKundeKonto();
                  
                }
                
                
                if(redigname.getText().isEmpty()==false){
                    kundas.setFuldnavn(redigname.getText());
                    updateKundeKonto();
                }
                
                if(redigtel.getText().isEmpty()==false){
                    kundas.setTelefonnr(Integer.parseInt(redigtel.getText()));
                    updateKundeKonto();
                }
                
                if(redigadd.getText().isEmpty()==false){
                    kundas.setAdresse(redigadd.getText());
                    updateKundeKonto();
                }
             if(redignypass.getText().isEmpty()==true&&redigname.getText().isEmpty()==true&&redigadd.getText().isEmpty()==true&&redigtel.getText().isEmpty()==true){
                    kunneik.setText("Ugyldig værdig");
                    updateKundeKonto();
                }   
            }
            } 
            }
            else if (pressed_button == skiftbutton) {
                redignypass.setVisible(true);
                rediggampass.setVisible(true);
                updateKundeKonto();
                
            }

         else if (pressed_button == tilbage0) {
            kundekontoPane.setVisible(false);
            shopPane.setVisible(true);
            updateKundeKonto();
        }
    }
    

    @FXML
    private void handleUnderleverandørAction(ActionEvent event) {

    }

    @FXML
    private void handleRegistrationAction(ActionEvent event) {
        Button pressed_button = (Button) event.getSource();
        if (pressed_button == regslut) {
            if((regname.getText().isEmpty()==false)&&(regaddr.getText().isEmpty()==false)&&(regtel.getText().isEmpty()==false)&&(reglog.getText().isEmpty()==false)&&(redadg.getText().isEmpty()==false)){
            mediator.getListOfKunder().add(new Kunde(regname.getText(),regaddr.getText(),reglog.getText(),redadg.getText(),Integer.parseInt(regtel.getText())));
            registerPane.setVisible(false);
            shopPane.setVisible(true);
            logpaa.setVisible(false);
            register.setVisible(false);
            logaf.setVisible(true);
            kundekonto.setVisible(true);
            mediator.getListOfKunder().add(new Kunde(regname.getText(),regaddr.getText(),reglog.getText(),redadg.getText(),Integer.parseInt(regtel.getText())));
            }
            else{
                regerrorlabel.setText("Ugældig data, Prøv igen");
                
            }
            } else if (pressed_button == tilbage1) {
            registerPane.setVisible(false);
            shopPane.setVisible(true);
        }

    }

    @FXML
    private void handleLogginAction(ActionEvent event) {
        Button pressed_button = (Button) event.getSource();
        if (pressed_button == kunde) {
            if(mediator.getKundeByLoginAndPassword(loginek.getText(), password.getText())!=null){
            loggingPane.setVisible(false);
            shopPane.setVisible(true);
            logpaa.setVisible(false);
            register.setVisible(false);
            logaf.setVisible(true);
            kundekonto.setVisible(true);
            
            password.clear();
            Kunde kundeczek =mediator.getKundeByLogin(loginek.getText());
            kundeoplys.setText(kundeczek.toString());
            List<Order> tmp0 = mediator.getAllOrdersByKunde(mediator.getKundeByLoginAndPassword(loginek.getText(), password.getText()));
            kundeorderer.getItems().addAll(tmp0);
            loginek.clear();
            }
        } else if (pressed_button == medarbejder) {
            
            loggingPane.setVisible(false);
            medarbejderPane.setVisible(true);
            loginek.clear();
            password.clear();
        } else if (pressed_button == under) {
            loggingPane.setVisible(false);
            udlevendørePane.setVisible(true);
            loginek.clear();
            password.clear();
        } else if (pressed_button == kamp) {
            loggingPane.setVisible(false);
            kampagnePane.setVisible(true);
            loginek.clear();
            password.clear();

        } else if (pressed_button == tilbage3) {
            loggingPane.setVisible(false);
            shopPane.setVisible(true);
            loginek.clear();
            password.clear();
        }
    }

    @FXML
    private void handleShoppingAction(ActionEvent event) {
        Button pressed_button = (Button) event.getSource();
        if (pressed_button == logpaa) {
            loggingPane.setVisible(true);
            shopPane.setVisible(false);
        } else if (pressed_button == register) {
            registerPane.setVisible(true);
            shopPane.setVisible(false);
        } else if (pressed_button == soueg) {
            soegpane.setVisible(true);

        } else if (pressed_button == addtocart) {

        } else if (pressed_button == removefromcart) {

        } else if (pressed_button == gaatilkassen) {
            kassePane.setVisible(true);
            shopPane.setVisible(false);
        } else if (pressed_button == logaf) {
            logaf.setVisible(false);
            register.setVisible(true);
            logpaa.setVisible(true);
            logaf.setVisible(false);
            kundekonto.setVisible(false);

        } else if (pressed_button == kundekonto) {
            shopPane.setVisible(false);
            kundekontoPane.setVisible(true);
        } else if (pressed_button == søgslut) {
            soegpane.setVisible(false);

        } else if (pressed_button == tilbage4) {
            soegpane.setVisible(false);

        }
    }

    @FXML
    private void handleSøgningAction(ActionEvent event) {
        RadioButton but = (RadioButton) group.getSelectedToggle();
        if (but == id) {
            søgkat.setVisible(false);
            søgid.setVisible(true);
            katlab.setVisible(false);
            if (søgid.getText() != null) {
                søgslut.setVisible(true);
            }
        } else if (but == kat) {
            søgid.setVisible(false);
            katlab.setVisible(true);
            søgkat.setVisible(true);
            if (søgkat.getItems() != null) {
                søgslut.setVisible(true);
            }
        }
    }

    private void updateKatalog() {
        this.katalog.getItems().clear();
        List<Varer> objects = mediator.getListOfVarer();
        this.katalog.getItems().addAll(objects);
    }
    private void updateKundeKonto(){
       this.kundeoplys.setText(null);
       List<Kunde> clients = mediator.getListOfKunder();
       for (Kunde kudin: clients){
       this.kundeoplys.setText(kudin.toString());
    }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shopPane.setVisible(true);
        rabat.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99));

        setRefAndInitialData(new Mediator());
        updateKatalog();
    }

    void setRefAndInitialData(Mediator mediator) {
        this.mediator = mediator;

    }

    // TODO
}