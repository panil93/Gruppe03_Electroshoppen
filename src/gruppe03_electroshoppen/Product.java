/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe03_electroshoppen;

import java.util.Date;

/**
 *
 * @author Termproject - SI2-ORG-U1 - Group 3 (Spring 2017)
 */
public class Product extends Commodity{

	private String SupplierName;
	private int SupplierId;
	private String SupplierProductCode;
	private String ProductCategory;
	private String Brand;
	private double CostPrice;
	private double CostPriceFreightFrom;
	private double CostPriceFreightTo;
	private double CostPriceHandlingFee;
	private double CostPriceWeeFee;

	private String EAN;
	private boolean Expired;
	private Date ExpiredDate;
	private int StockQuantity;
	private Date LastRestocked;
	private String ShortReelDescription;
	private String LongDescription;
	private String ShortDescription;
	private String Title;
	private int DeliveryTime;
	private double Weight;
	private double Lenght;
	private double Width;
	private double Height;
	private Date ConvertedDate;
	private Date Created;
	private Date Modified;
	private int NextDeliveryQuantity;
	private Date DeliveryDate;
	private Date PriceLastModified;

	public Product(double RetailPrice, String CompanyId, String SupplierName, int SupplierId, String SupplierProductCode, String ProductCategory, String Brand, double CostPrice, double CostPriceFreightFrom, double CostPriceFreightTo, double CostPriceHandlingFee, double CostPriceWeeFee, String EAN, boolean Expired, Date ExpiredDate, int StockQuantity, Date LastRestocked, String ShortReelDescription, String LongDescription, String ShortDescription, String Title, int DeliveryTime, double Weight, double Lenght, double Width, double Height, Date ConvertedDate, Date Created, Date Modified, int NextDeliveryQuantity, Date DeliveryDate, Date PriceLastModified) {
		super(RetailPrice, CompanyId);
		this.SupplierName = SupplierName;
	}

	public double calculatePriceWithRabat(int rabat, double spris) {
		double factor = ((double) rabat) / 100;
		double total_rabat = spris * factor;

		return spris - total_rabat;
	}

	public String getCategory() {
		return this.ProductCategory;
	}

	@Override
	public String toString() {
		return (this.SupplierName + " " + RetailPrice);

	}

}
