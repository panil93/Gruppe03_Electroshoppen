/**
 * FXML Controller class
 *
 */
package GUI;

import gruppe03_electroshoppen.Betaling;
import gruppe03_electroshoppen.Butik;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SpinnerValueFactory;

/**
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class MenuFXMLController implements Initializable {

	private Mediator mediator;
	private String stedtiludlevering = null;

	//Shop Pane
	@FXML
	private AnchorPane shopPane;
	@FXML
	private ListView banner;
	@FXML
	private Button register;
	@FXML
	private Button logpaa;
	@FXML
	private Button logaf;
	@FXML
	private ListView<Varer> katalog;
	@FXML
	private ListView<Varer> cart;
	@FXML
	private Button addtocart;
	@FXML
	private Button removefromcart;
	@FXML
	private Button gaatilkassen;
	@FXML
	private Button soueg;
	@FXML
	private Button kundekonto;
	
	//Search Pane
	@FXML
	private Pane soegpane;
	@FXML
	private RadioButton kat;
	@FXML
	private RadioButton id;
	@FXML
	private TextField søgid;
	@FXML
	private Label katlab;
	@FXML
	private Button søgslut;
	@FXML
	private Button tilbage4;
	@FXML
	private ListView søgkat;
	
	//Order Pane
	@FXML
	private AnchorPane kassePane;
	@FXML
	private ListView orderPaneOrder;
	@FXML
	private Button orderPaneLogOff;
	@FXML
	private Button orderPaneBack;
	@FXML
	private Button orderPaneContinue;
	@FXML
	private TextField totalpris;
	@FXML
	private TextField procent;
	@FXML
	private RadioButton hjem;
	@FXML
	private RadioButton collect;
	@FXML
	private ToggleGroup hente;
	
	//Collect Pane
	@FXML
	private Pane collectPane;
	@FXML
	private ListView listButikker;
	@FXML
	private Button chooseButton;
	
	//Invoice Info Pane
	@FXML
	private AnchorPane invoiceInfoPane;
	@FXML
	private Button invoiceInfoPaneContinue;
	@FXML
	private TextField invoiceInfoPaneName;
	@FXML
	private TextField invoiceInfoPaneEmail;
	@FXML
	private TextField invoiceInfoPaneTelefon;
	@FXML
	private TextField invoiceInfoPaneAddress1;
	@FXML
	private CheckBox invoiceInfoPaneCreateAccount;
	@FXML
	private ChoiceBox<String> invoiceInfoPaneCountry;
	@FXML
	private TextField invoiceInfoPanePostCode;
	@FXML
	private TextField invoiceInfoPaneAddress2;
	@FXML
	private TextField invoiceInfoPaneCity;
	@FXML
	private ListView<Varer> invoiceInfoPaneOrder;
	@FXML
	private TextField invoiceInfoPaneTotalPrice;
	@FXML
	private TextArea invoiceInfoPaneMessage;
	@FXML
	private CheckBox invoiceInfoPaneDiffrentAddress;
	@FXML
	private Button invoiceInfoPaneBack;
	@FXML
	private Button invoiceInfoPaneLogOff;
	
	//Payment Pane
	@FXML
	private AnchorPane paymentPane;
	@FXML
	private ListView<Varer> paymentPaneOrder;
	@FXML
	private TextField paymentPaneTotalPrice;
	@FXML
	private TextField paymentPaneCardNumber;
	@FXML
	private TextField paymentPaneControl;
	@FXML
	private ChoiceBox<?> paymentPaneDateMonth;
	@FXML
	private ChoiceBox<?> paymentPaneDateYear;
	@FXML
	private CheckBox paymentPaneCondition;
	@FXML
	private Button paymentPaneContinue;
	@FXML
	private Button paymentPaneBack;
	@FXML
	private Button paymentPaneLogOff;

	//Receipt Pane
	@FXML
	private AnchorPane receiptPane;
	@FXML
	private ListView<Varer> receiptPaneOrder;
	@FXML
	private TextArea receiptPaneMessage;
	@FXML
	private Button receiptPanePrint;
	@FXML
	private Button receiptPaneBack;
	@FXML
	private TextField receiptPaneTotalPrice;
	@FXML
	private Button receiptPaneLogOff;
	
	//Register Pane
	@FXML
	private AnchorPane registerPane;
	@FXML
	private TextField regname;
	@FXML
	private TextField regaddr;
	@FXML
	private TextField regtel;
	@FXML
	private TextField reglog;
	@FXML
	private TextField redadg;
	@FXML
	private Button regslut;
	@FXML
	private Button tilbage1;
	
	//Log in Pane
	@FXML
	private AnchorPane loggingPane;
	@FXML
	private Button tilbage3;
	@FXML
	private Button kunde;
	@FXML
	private Button medarbejder;
	@FXML
	private Button under;
	@FXML
	private Button kamp;
	@FXML
	private TextField loginek;
	@FXML
	private TextField password;
	
	//User Account Pane
	@FXML
	private AnchorPane kundekontoPane;
	@FXML
	private Button tilbage0;
	@FXML
	private Button logafff;
	@FXML
	private Button nyreklam;
	@FXML
	private Button redigopl;
	@FXML
	private TextField kundetilbud;
	@FXML
	private ListView kundeorderer;
	@FXML
	private ListView kundereklam;
	@FXML
	private TextArea kundeoplys;
	
	//
	@FXML
	private Pane redigeringsPane;
	@FXML
	private Button skiftbutton;
	@FXML
	private Button gemoplys;
	@FXML
	private TextField redigname;
	@FXML
	private TextField redigadd;
	@FXML
	private TextField redigtel;
	@FXML
	private TextField rediggampass;
	@FXML
	private TextField redignypass;
	
	//Reclamation
	@FXML
	private Pane reklampane;
	@FXML
	private ListView reklamord;
	@FXML
	private TextField reklamaars;
	@FXML
	private ListView reklamprod;
	@FXML
	private TextField reklamlist;
	@FXML
	private ToggleGroup reklamationer;
	@FXML
	private RadioButton penge;
	@FXML
	private RadioButton varer;
	@FXML
	private Button opretreklam;
	
	//Employee Pane
	@FXML
	private AnchorPane medarbejderPane;
	@FXML
	private Button infobutton;
	@FXML
	private Button markmed;
	@FXML
	private Button logaffff;
	@FXML
	private TextField pakkeoplys;
	@FXML
	private TextArea pakkemodtag;
	@FXML
	private ListView pakkedetaj;

	//Supplyer Pane
	@FXML
	private AnchorPane udlevendørePane;
	@FXML
	private ListView undlist;
	@FXML
	private ListView unddet;
	@FXML
	private Button undmak;
	@FXML
	private Button undan;
	@FXML
	private Button SupplyerPaneLogOff;
	
	//Campaign Pane
	@FXML
	private AnchorPane kampagnePane;
	@FXML
	private Button nykamp;
	@FXML
	private Button logaff;
	
	//New Campaign Pane
	@FXML
	private Pane nykampPane;
	@FXML
	private ToggleGroup kamptog;
	@FXML
	private RadioButton web;
	@FXML
	private RadioButton pos;
	@FXML
	private RadioButton begge;
	@FXML
	private RadioButton newCampaignPanePersonal;
	@FXML
	private Spinner rabat;
	@FXML
	private DatePicker stardate;
	@FXML
	private DatePicker slutdate;
	@FXML
	private Button opretbutton;
	@FXML
	private Button nykampPanelogaff;
	
	//Hvor hører de her hjemme?
	@FXML
	private Label totalLabel;
	@FXML
	private ToggleGroup group;
	@FXML
	private Label formedarb;
	@FXML
	private Label regerrorlabel;
	@FXML
	private Label kunneik;
	@FXML
	private ToggleGroup kamptog1;


	/**
	 * This
	 *
	 * @param url, rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		//
		shopPane.setVisible(true);
		//
		rabat.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99));
		//
		setRefAndInitialData(new Mediator());
		//
		updateKatalog();
		//
		updateButikker();

	}
	
	/**
	 * This method handles the...
	 *
	 * @param event
	 */
	@FXML
	private void handleMedarbejderAction(ActionEvent event) {
		
		pakkedetaj.getItems().removeAll();
		Button pressed_button = (Button) event.getSource();
		
		if (pressed_button == logaffff) {
			
			medarbejderPane.setVisible(false);
			shopPane.setVisible(true);
			
		} else if (pressed_button == infobutton) {
			
			pakkedetaj.getItems().clear();
			
			//
			for (Order ordy : mediator.getListOfOrder()) {
				
				//
				String test = pakkeoplys.getText();
				
				//
				if (Integer.parseInt(test) == (ordy.getId())) {
					
					Kunde t = mediator.getKundeByOrder(ordy.getId());
					String t2 = mediator.getKundeByOrder(ordy.getId()).getAdresse();
					pakkemodtag.setText(t.getName() + "\n" + t2);
					
					//
					for (Varer v : mediator.getVarerByOrder(Integer.parseInt(pakkeoplys.getText()))) {
						
						//
						if (v != null) {
							
							pakkedetaj.getItems().add(v);
							
						}
					}
				} else {
					
					//pakkemodtag.setText("Findes ikke");
					//pakkedetaj.getItems().add("Findes ikke");
				}
			}
		} else if (pressed_button == markmed) {
				
			List<Order> ord = mediator.getListOfOrder();
			Iterator<Order> i = ord.iterator();
			
			//
			while (i.hasNext()) {
				
				//
				Order o = i.next();
				
				//
				if (o.getId() == Integer.parseInt(pakkeoplys.getText())) {
					
					mediator.RemoveListOfOrder(o);

				}
			}

			//pakkemodtag.clear();
			pakkedetaj.getItems().clear();
			//pakkeoplys.clear();
		}
	}

	/**
	 * This method handles the...
	 *
	 * @param event
	 */
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
			
		}else if(pressed_button == nykampPanelogaff){
		
			kampagnePane.setVisible(false);
			shopPane.setVisible(true);
			register.setVisible(true);
			logpaa.setVisible(true);
			kundekonto.setVisible(false);
			logaf.setVisible(false);
			
		}
	}

	/**
	 * This method handles the...
	 *
	 * @param event
	 */
	private void handleKampagnePaneAction(ActionEvent event) {
		
		double newPrice = 0;
		RadioButton radiusek = (RadioButton) kamptog.getSelectedToggle();
		
		if (radiusek == web) {
			
			List<Varer> tester = mediator.getListOfVarer();
			
			for (Varer v : mediator.getListOfVarer()) {
			
				if (v instanceof Produkt) {
					
					newPrice = ((Produkt) v).calculatePriceWithRabat((Integer) rabat.getValue(), v.getPris());
					v.setPris(newPrice);
					formedarb.setText("Du har opretter kampagne med " + rabat.getValue() + "% rabat i Webshoppen");
					
					if ((stardate.getValue().isBefore(LocalDate.now()) && slutdate.getValue().isAfter(LocalDate.now()))) {
						
						banner.getItems().add("Vild tilbud! hele " + rabat.getValue() + "% kun i Webshoppen");
					
					}

				}

			}

		} else if (radiusek == pos) {
			
			formedarb.setText("Du har opretter kampagne med " + rabat.getValue() + "% rabat i Points of Sale");
			
			if ((stardate.getValue().isBefore(LocalDate.now()) && slutdate.getValue().isAfter(LocalDate.now()))) {
				
				banner.getItems().add("Vild tilbud! hele " + rabat.getValue() + "% kun i POS");
			
			}

		} else if (radiusek == begge) {
			
			List<Varer> tester = mediator.getListOfVarer();
			
			for (Varer v : mediator.getListOfVarer()) {
				
				if (v instanceof Produkt) {
					
					newPrice = ((Produkt) v).calculatePriceWithRabat((Integer) rabat.getValue(), v.getPris());

					v.setPris(newPrice);
					formedarb.setText("Du har opretter kampagne med " + rabat.getValue() + "% rabat i både Webshoppen og Points of Sale");
					
					if ((stardate.getValue().isBefore(LocalDate.now()) && slutdate.getValue().isAfter(LocalDate.now()))) {
						
						banner.getItems().add("Vild tilbud! hele " + rabat.getValue() + "% kun i Electroshoppen");
					
					}
				}

			}
			updateKatalog();
		}
	}

	/**
	 * This method handles the...
	 *
	 * @param event
	 */
	@FXML
	private void handleKasseAction(ActionEvent event) {

		Button b = (Button) event.getSource();
		int id = 0;
		Kunde kunde = null;
		double orderPrice = 0.0;
		List<Varer> listOfVarer = null;

		if (b == gaatilkassen) {

			if(cart.getItems().isEmpty()){
			
				return;
			}
			
			
			
			
			//User has to log on to continue.			
			if(kundekonto.isVisible()== false){
			
			return;
			
			}
			
			kassePane.setVisible(true);
			shopPane.setVisible(false);
			
	
		}

		//String stedtiludlevering = null;
		//else if (b == tilbage2) {
		//	shopPane.setVisible(true);
		//		} 
		//else if (b == bet) {
		//	invoiceInfoPane.setVisible(true);
		//	invoiceInfoPaneTotalPrice.setText(totalpris.getText());
		//	kassePane.setVisible(false);
		//	handleForsendelseAction(event);
		//} else if (b == chooseButton) {
		//	collectPane.setVisible(false);
		//	stedtiludlevering = listButikker.getSelectionModel().getSelectedItem().toString();
		//}
		// Order buyorder = new Order(id, stedtiludlevering, kunde, orderPrice, listOfVarer);
	}

	/**
	 * This method handles the Radio buttons on 
	 *
	 * @param event
	 */
	@FXML
	private void handleForsendelseAction(ActionEvent event) {

		RadioButton radiob = (RadioButton) hente.getSelectedToggle();

		if (radiob == collect) {

			listButikker.getItems().clear();
			collectPane.setVisible(true);

			for (Butik butik_to : mediator.getListOfButikker()) {

				if (butik_to != null) {

					listButikker.getItems().add(butik_to.getAdresse());
					invoiceInfoPaneDiffrentAddress.disableProperty();

				}
			}

		} else if (radiob == hjem) {

			listButikker.getItems().clear();

		}

	}

	/**
	 * This method handles the ChooseButton button on Collect Pane on Order
	 * Pane.
	 *
	 * @param event
	 */
	@FXML
	private void handleChooseButtonAction(ActionEvent event) {

		//Handels if no store is chosen. When clicked nothing happens on the screen. 
		if (listButikker.getSelectionModel().getSelectedItem() == null) {

			return;
		}

		stedtiludlevering = listButikker.getSelectionModel().getSelectedItem().toString();
		collectPane.setVisible(false);
	}

	/**
	 * This method handles the GoToInvoice button on Order Pane.
	 *
	 * @param event
	 */
	@FXML
	private void handleGoToInvoiceAction(ActionEvent event) {

		setAllPaneInvisibleButOne(invoiceInfoPane);
		invoiceInfoPaneTotalPrice.setText(totalpris.getText());
		invoiceInfoPaneCountry.setValue("Danmark");
		
	}

	/**
	 * This method handles the GoToPayment button on Invoice pane.
	 *
	 * @param event
	 */
	@FXML
	private void handleGoToPaymentAction(ActionEvent event) {

		setAllPaneInvisibleButOne(paymentPane);
		paymentPaneTotalPrice.setText(totalpris.getText());

	}

	/**
	 * This method handles the GoToReceipt button on Payment pane.
	 *
	 * @param event
	 */
	@FXML
	private void handleGoToReceiptAction(ActionEvent event) {

		//listOfVarer<> =cart.getItems();
		
		setAllPaneInvisibleButOne(receiptPane);
		receiptPaneTotalPrice.setText(totalpris.getText());
		receiptPaneMessage.setText("Tak for din bestilling" + "\n" + "Vi har sendt din kvittering til " + invoiceInfoPaneEmail.getText());
		
		
		// Order order = new Order(id, stedtiludlevering, kunde, totalpris, listOfVarer);
       // Betaling betaling = new Betaling(totalpris, dato, kunde, order);
		
	}

	/**
	 * This method handles the Back button on Order Pane, Invoice pane, Payment
	 * pane, and keeps the selected info. When clicked the user returns to the
	 * webshop.
	 *
	 * @param event
	 */
	@FXML
	private void handleBackButtonsAction(ActionEvent event) {

		setAllPaneInvisibleButOne(shopPane);

	}

	/**
	 * This method handles the Back button on Receipt pane, and clears the
	 * selected info. When clicked the user returns to the webshop.
	 *
	 * @param event
	 */
	@FXML
	private void handleReceiptPaneBackButtonAction(ActionEvent event) {

		setAllPaneInvisibleButOne(shopPane);
		clearAllItemsAndTotalprice();

	}

	/**
	 * This method handles the...
	 *
	 * @param event
	 */
	@FXML
	private void handleLogOffButtonAction(ActionEvent event) {

		register.setVisible(true);
		logpaa.setVisible(true);
		logaf.setVisible(false);
		setAllPaneInvisibleButOne(shopPane);
		clearAllItemsAndTotalprice();

	}

	/**
	 * This method handles the...
	 *
	 * @param event
	 */
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

		} else if (pressed_button == gemoplys) {

			Order orde;
			Button button = (Button) event.getSource();

			if (button == gemoplys) {

				redigeringsPane.setVisible(false);

				for (Kunde kundas : mediator.getListOfKunder()) {

					if (kundas.toString().compareTo(kundeoplys.getText()) == 0) {

						if ((redignypass.getText().isEmpty() == false) && (rediggampass.getText().compareTo(kundas.getAdgangskode())) == 0) {

							kundas.setAdgangskode(redignypass.getText());
							rediggampass.setVisible(false);
							redignypass.setVisible(false);
							updateKundeKonto();

						}

						if (redigname.getText().isEmpty() == false) {

							kundas.setFuldnavn(redigname.getText());
							updateKundeKonto();

						}

						if (redigtel.getText().isEmpty() == false) {

							kundas.setTelefonnr(Integer.parseInt(redigtel.getText()));
							updateKundeKonto();
						}

						if (redigadd.getText().isEmpty() == false) {

							kundas.setAdresse(redigadd.getText());
							updateKundeKonto();

						}
						if (redignypass.getText().isEmpty() == true && redigname.getText().isEmpty() == true && redigadd.getText().isEmpty() == true && redigtel.getText().isEmpty() == true) {

							kunneik.setText("Ugyldig værdig");
							updateKundeKonto();

						}
					}
				}
			} else if (pressed_button == skiftbutton) {

				redignypass.setVisible(true);
				rediggampass.setVisible(true);
				updateKundeKonto();

			} else if (pressed_button == tilbage0) {

				kundekontoPane.setVisible(false);
				shopPane.setVisible(true);
				updateKundeKonto();
			}
		}

	}

	/**
	 * This method handles the...
	 *
	 * @param event
	 */
	@FXML
	private void handleUnderleverandørAction(ActionEvent event) {

	}

	/**
	 * This method handles the...
	 *
	 * @param event
	 */
	@FXML
	private void handleRegistrationAction(ActionEvent event) {

		Button pressed_button = (Button) event.getSource();

		if (pressed_button == regslut) {

			if ((regname.getText().isEmpty() == false) && (regaddr.getText().isEmpty() == false) && (regtel.getText().isEmpty() == false) && (reglog.getText().isEmpty() == false) && (redadg.getText().isEmpty() == false)) {

				mediator.getListOfKunder().add(new Kunde(regname.getText(), regaddr.getText(), reglog.getText(), redadg.getText(), Integer.parseInt(regtel.getText())));
				registerPane.setVisible(false);
				shopPane.setVisible(true);
				logpaa.setVisible(false);
				register.setVisible(false);
				logaf.setVisible(true);
				kundekonto.setVisible(true);
				mediator.getListOfKunder().add(new Kunde(regname.getText(), regaddr.getText(), reglog.getText(), redadg.getText(), Integer.parseInt(regtel.getText())));

			} else {

				regerrorlabel.setText("Ugyldig data, Prøv igen");

			}
		} else if (pressed_button == tilbage1) {

			registerPane.setVisible(false);
			shopPane.setVisible(true);
		}

	}

	/**
	 * This method handles the...
	 *
	 * @param event
	 */
	@FXML
	private void handleLogginAction(ActionEvent event) {

		Button pressed_button = (Button) event.getSource();

		if (pressed_button == kunde) {

			if (mediator.getKundeByLoginAndPassword(loginek.getText(), password.getText()) != null) {

				loggingPane.setVisible(false);
				shopPane.setVisible(true);
				logpaa.setVisible(false);
				register.setVisible(false);
				logaf.setVisible(true);
				kundekonto.setVisible(true);

				password.clear();
				Kunde kundeczek = mediator.getKundeByLogin(loginek.getText());
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

	/**
	 * This method handles the...
	 *
	 * @param event
	 */
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

			//If no item is selected, nothing happens on the screen.
			if(katalog.getSelectionModel().getSelectedItem() == null){
		
				return;
			}
			
			cart.getItems().add(katalog.getSelectionModel().getSelectedItem());
			orderPaneOrder.getItems().add(katalog.getSelectionModel().getSelectedItem());
			paymentPaneOrder.getItems().add(katalog.getSelectionModel().getSelectedItem());
			invoiceInfoPaneOrder.getItems().add(katalog.getSelectionModel().getSelectedItem());
			receiptPaneOrder.getItems().add(katalog.getSelectionModel().getSelectedItem());

			double totalPris = 0;

			for (Varer v : cart.getItems()) {

				totalPris += v.getPris();
				String total2 = String.valueOf(totalPris);
				totalpris.setText(total2);
			}

		} else if (pressed_button == removefromcart) {

			cart.getItems().remove(katalog.getSelectionModel().getSelectedItem());
			orderPaneOrder.getItems().remove(katalog.getSelectionModel().getSelectedItem());
			paymentPaneOrder.getItems().remove(katalog.getSelectionModel().getSelectedItem());
			invoiceInfoPaneOrder.getItems().remove(katalog.getSelectionModel().getSelectedItem());
			receiptPaneOrder.getItems().remove(katalog.getSelectionModel().getSelectedItem());

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

	/**
	 * This method handles the...
	 *
	 * @param event
	 */
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

	/**
	 * This method handles the...
	 *
	 */
	private void updateKatalog() {
		this.katalog.getItems().clear();
		List<Varer> objects = mediator.getListOfVarer();

		//
		for (Varer v : objects) {
			
			//
			if (v != null) {
				
				this.katalog.getItems().add(v);
			
			}
		}

	}

	/**
	 * This method handles the...
	 *
	 */
	private void updateKundeKonto() {

		this.kundeoplys.setText(null);
		List<Kunde> clients = mediator.getListOfKunder();

		//
		for (Kunde kudin : clients) {
			
			this.kundeoplys.setText(kudin.toString());

		}
	}

	/**
	 * This method handles the...
	 *
	 */
	private void updateButikker() {

		this.listButikker.getItems().removeAll();
		List<Butik> butikker = mediator.getListOfButikker();

		//
		for (Butik shopper : butikker) {
			
			//
			if (shopper != null) {
				
				this.listButikker.getItems().add(shopper);
				
			}
		}
	}

	

	/**
	 * This method handles the...
	 *
	 * @param mediator
	 */
	void setRefAndInitialData(Mediator mediator) {

		this.mediator = mediator;

	}

	/**
	 * This method sets only one pane visible.
	 *
	 * @param pane
	 */
	private void setAllPaneInvisibleButOne(Pane pane) {

		if (pane != shopPane) {
			shopPane.setVisible(false);
		}
		if (pane != kassePane) {
			kassePane.setVisible(false);
		}
		if (pane != invoiceInfoPane) {
			invoiceInfoPane.setVisible(false);
		}
		if (pane != paymentPane) {
			paymentPane.setVisible(false);
		}
		if (pane != receiptPane) {
			receiptPane.setVisible(false);
		}
		if (pane != medarbejderPane) {
			medarbejderPane.setVisible(false);
		}
		if (pane != loggingPane) {
			loggingPane.setVisible(false);
		}
		if (pane != registerPane) {
			registerPane.setVisible(false);
		}
		if (pane != kampagnePane) {
			kampagnePane.setVisible(false);
		}
		if (pane != kundekontoPane) {
			kundekontoPane.setVisible(false);
		}
		if (pane != udlevendørePane) {
			udlevendørePane.setVisible(false);
		}

		pane.setVisible(true);
	}

	/**
	 * This method clears all selected items and totalprice in the webshop.
	 *
	 */
	private void clearAllItemsAndTotalprice() {

		cart.getItems().clear();
		orderPaneOrder.getItems().clear();
		hjem.setSelected(true);
		collect.setSelected(false);
		listButikker.getItems().clear();
		invoiceInfoPaneOrder.getItems().clear();
		invoiceInfoPaneName.setText("");
		invoiceInfoPaneEmail.setText("");
		invoiceInfoPaneTelefon.setText("");
		invoiceInfoPanePostCode.setText("");
		invoiceInfoPaneAddress1.setText("");
		invoiceInfoPaneAddress2.setText("");
		invoiceInfoPaneCity.setText("");
		invoiceInfoPaneMessage.setText("");
		paymentPaneOrder.getItems().clear();
		receiptPaneOrder.getItems().clear();
		totalpris.clear();

	}

}
