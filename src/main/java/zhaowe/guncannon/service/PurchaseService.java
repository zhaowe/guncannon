package zhaowe.guncannon.service;

import java.util.Collection;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import zhaowe.guncannon.dao.mybatis.mariadb.PurchaseDAO;
import zhaowe.guncannon.model.PurchaseItem;
import zhaowe.guncannon.model.PurchaseListItem;
import zhaowe.guncannon.util.Logger;

public class PurchaseService {
	static final private PurchaseDAO dao = new PurchaseDAO();

	public PurchaseService() {
	}

	public Collection<PurchaseListItem> getPlants() {
		final String methodName = "getPlants";
		Logger.infoStarted(methodName);
		Logger.infoFinished(methodName);
		return dao.getAll();
	}

	public String printJson(Collection<PurchaseListItem> collection) {
		final String methodName = "printJson";
		Logger.infoStarted(methodName);

		JsonArrayBuilder builder = Json.createArrayBuilder();
		for (PurchaseListItem plant : collection) {
			builder.add(plant.toJson());
		}
		JsonArray ja = builder.build(); 
		Logger.infoFinished(methodName);
		return ja.toString();
	}

	public PurchaseItem getPlant(String key) {
		final String methodName = "getPlant";
		Logger.infoStarted(methodName);
		Logger.infoFinished(methodName);
		return dao.get(key);
	}
}
