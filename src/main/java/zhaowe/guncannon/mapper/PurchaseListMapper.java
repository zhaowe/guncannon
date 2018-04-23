package zhaowe.guncannon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import zhaowe.guncannon.model.PurchaseListItem;

public interface PurchaseListMapper {
	@Select("select id, name, category, specification, purchaser, purchasingDate, price, vendor " +
			"from purchase_items")
	List<PurchaseListItem> getAll();
}
