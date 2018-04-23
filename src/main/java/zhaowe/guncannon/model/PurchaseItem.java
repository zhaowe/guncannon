package zhaowe.guncannon.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;

public class PurchaseItem {
    private String id, name, category, specification, unit;
    private double price;
    private String vendor, phone, origin, purchaser;
    private Date purchasingDate;
	private double amount;
    static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getPhoneNo() {
		return phone;
	}
	public void setPhoneNo(String phone) {
		this.phone = phone;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	public Date getPurchasingDate() {
		return purchasingDate;
	}
	public void setPurchasingDate(Date purchasingDate) {
		this.purchasingDate = purchasingDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public JsonObject toJson() {
		return Json.createObjectBuilder()
				.add("amount", getAmount())
				.add("category", getCategory())
				.add("name", getName())
				.add("origin", getOrigin())
				.add("phoneNo", getPhoneNo())
				.add("price", getPrice())
				.add("purchaser", getPurchaser())
				.add("purchasingDate", df.format(getPurchasingDate()))
				.add("id", getId())
				.add("specification", getSpecification())
				.add("unit", getUnit())
				.add("vendor", getVendor())
				.build();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
