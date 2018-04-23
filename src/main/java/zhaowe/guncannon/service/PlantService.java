package zhaowe.guncannon.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import zhaowe.guncannon.model.PurchaseItem;
import zhaowe.guncannon.util.Logger;

public class PlantService {
	static final private HashMap<String, PurchaseItem> plants = new HashMap<String, PurchaseItem>();

	public PlantService() {
		if (plants.size() > 0)
			return;
		PurchaseItem p;

		try {
			SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd");
			p = new PurchaseItem();
			p.setAmount(36);
			p.setCategory("辅材");
			p.setId("5001");
			p.setName("保丽龙大板");
			p.setOrigin("CAAA1");
			p.setPhoneNo("CAAA1");
			p.setPrice(180.0);
			p.setPurchaser("陈村花湾城");
			p.setPurchasingDate(df.parse("16/10/31"));
			p.setSpecification("14KG2*1*0.56M");
			p.setUnit("PCS");
			p.setVendor("吴祝福");

			PlantService.plants.put(p.getId(), p);

			p = new PurchaseItem();
			p.setAmount(6);
			p.setCategory("辅材");
			p.setId("5002");
			p.setName("预埋件十厘钢板大板");
			p.setOrigin("CAAB1");
			p.setPhoneNo("138 0283 6677");
			p.setPrice(62.8);
			p.setPurchaser("陈村花湾城");
			p.setPurchasingDate(df.parse("16/09/29"));
			p.setSpecification("400*250");
			p.setUnit("件");
			p.setVendor("浩海装饰(陈如华)");

			PlantService.plants.put(p.getId(), p);

			p = new PurchaseItem();
			p.setAmount(120);
			p.setCategory("管材");
			p.setId("4001");
			p.setName("联塑线管");
			p.setOrigin("佛山");
			p.setPhoneNo("159 1455 6588");
			p.setPrice(6.86);
			p.setPurchaser("陈村花湾城");
			p.setPurchasingDate(df.parse("16/10/31"));
			p.setSpecification("25*4M*A");
			p.setUnit("条");
			p.setVendor("郑扬贵");

			PlantService.plants.put(p.getId(), p);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Collection<PurchaseItem> getPlants() {
		final String methodName = "getPlants";
		Logger.infoStarted(methodName);
		Logger.infoFinished(methodName);
		return plants.values();
	}

	public String printJson(Collection<PurchaseItem> list) {
		final String methodName = "printJson";
		Logger.infoStarted(methodName);
//		ArrayList<JsonObject> jsons = ew ArrayList<JsonObject>();
		JsonArrayBuilder builder = Json.createArrayBuilder();
		for (PurchaseItem plant : list) {
			builder.add(plant.toJson());
		}
		JsonArray ja = builder.build(); 
		Logger.infoFinished(methodName);
		return ja.toString();
	}

	public PurchaseItem getPlant(String key) {
		return plants.get(key);
	}
}
