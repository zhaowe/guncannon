package zhaowe.guncannon.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonValue;

public class PurchaseListItem {
    private String id, name, category, specification, purchaser, vendor;
	private Date purchasingDate;
	private double price;

    static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}

	public String getPurchasingDate() {
		return df.format(purchasingDate);
	}

	public void setPurchasingDate(Date purchasingDate) {
		this.purchasingDate = purchasingDate;
	}

	public void setPurchasingDate(String purchasingDate) {
		try {
			this.purchasingDate = df.parse(purchasingDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public JsonValue toJson() {
		return Json.createObjectBuilder()
				.add("category", getCategory())
				.add("name", getName())
				.add("price", getPrice())
				.add("purchaser", getPurchaser())
				.add("purchasingDate", getPurchasingDate())
				.add("id", getId())
				.add("specification", getSpecification())
				.add("vendor", getVendor())
				.build();
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
}
