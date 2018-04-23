package zhaowe.guncannon.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import zhaowe.guncannon.model.PurchaseItem;

public interface PurchaseItemMapper {
	@Select("select * from purchase_items where id = #{id}")
	PurchaseItem get(String sn);
	
	@Insert("insert into purchase_items (name, category, specification, unit, " + 
			"price, vendor, phone, origin, purchaser, purchasingDate, amount) " +
			"values (#{name}, #{category}, #{specification}, #{unit}, " +
			"#{price}, #{vendor}, #{phone}, #{origin}, #{purchaser}, #{purchasingDate}, #{amount})")
	void put(PurchaseItem item);
	
	@Update("create table if not exists purchase_items(id int primary key auto_increment, " +
			"name varchar(255), category varchar(255), specification varchar(255), " +
			"unit varchar(255), price double, vendor varchar(255), phone varchar(255), " +
			"origin varchar(255), purchaser varchar(255), purchasingDate timestamp, " +
			"amount double);")
	void build();
}
