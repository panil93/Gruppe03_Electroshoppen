/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import gruppe03_electroshoppen.Kunde;
import gruppe03_electroshoppen.Produkt;
import gruppe03_electroshoppen.Service;
import gruppe03_electroshoppen.Varer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class LoadVarer extends Loader {

	private List<Varer> product_list = new ArrayList();
	private HashMap<String, Varer> kunde_list;

	@Override
	public void load() {
		File file = new File("varer.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file); // scanner for the file
		} catch (FileNotFoundException ex) {
			try {
				//if not such file exists create it.
				file.createNewFile();
			} catch (IOException ex1) {
				Logger.getLogger(LoadKunder.class.getName()).log(Level.SEVERE, null, ex1);
				return;
			}
		}
		while (scanner.hasNextLine()) {
			switch (scanner.nextLine()) {
				case "[Produkt]:":
					double RetailPrice = Double.parseDouble(scanner.nextLine());
					String CompanyId = scanner.nextLine();
					String SupplierName = scanner.nextLine();
					int SupplierId = Integer.parseInt(scanner.nextLine());
					String SupplierProductCode = scanner.nextLine();
					String ProductCategory = scanner.nextLine();
					String Brand = scanner.nextLine();
					double CostPrice = Double.parseDouble(scanner.nextLine());
					double CostPriceFreightFrom = Double.parseDouble(scanner.nextLine());
					double CostPriceFreightTo = Double.parseDouble(scanner.nextLine());
					double CostPriceHandlingFee = Double.parseDouble(scanner.nextLine());
					double CostPriceWeeFee = Double.parseDouble(scanner.nextLine());
					String EAN = scanner.nextLine();
					boolean Expired = Boolean.parseBoolean(scanner.nextLine());
					Date ExpiredDate = this.readDate(scanner);
					int StockQuantity = Integer.parseInt(scanner.nextLine());
					Date LastRestocked = this.readDate(scanner);
					String ShortReelDescription = scanner.nextLine();
					String LongDescription = scanner.nextLine();
					String ShortDescription = scanner.nextLine();
					String Title = scanner.nextLine();
					int DeliveryTime = Integer.parseInt(scanner.nextLine());
					double Weight = Double.parseDouble(scanner.nextLine());
					double Lenght = Double.parseDouble(scanner.nextLine());
					double Width = Double.parseDouble(scanner.nextLine());
					double Height = Double.parseDouble(scanner.nextLine());
					Date ConvertedDate = this.readDate(scanner);
					Date Created = this.readDate(scanner);
					Date Modified = this.readDate(scanner);
					int NextDeliveryQuantity = Integer.parseInt(scanner.nextLine());
					Date DeliveryDate = this.readDate(scanner);
					Date PriceLastModified = this.readDate(scanner);

					Varer produkt = new Produkt(RetailPrice, CompanyId, SupplierName, SupplierId, SupplierProductCode, ProductCategory, Brand, CostPrice, CostPriceFreightFrom, CostPriceFreightTo, CostPriceHandlingFee, CostPriceWeeFee, EAN, Expired, ExpiredDate, StockQuantity, LastRestocked, ShortReelDescription, LongDescription, ShortDescription, Title, DeliveryTime, Weight, Lenght, Width, Height, ConvertedDate, Created, Modified, NextDeliveryQuantity, DeliveryDate, PriceLastModified);
					this.product_list.add(produkt);
					break;
				case "[Service]:":
					double RetailPrice0 = Double.parseDouble(scanner.nextLine());
					String CompanyId0 = scanner.nextLine();
					String navn = scanner.nextLine();
					Varer service = new Service(CompanyId0, navn, RetailPrice0);
					this.product_list.add(service);

					break;

				default:
					break;
			}
		}
	}

	public List<Varer> getProduktKatalog() {
		return this.product_list;
	}
}
