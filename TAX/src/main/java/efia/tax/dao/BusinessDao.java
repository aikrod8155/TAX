package efia.tax.dao;

import java.util.List;
import java.util.Map;

import efia.tax.entity.Business;

public interface BusinessDao {
	int coutByCondition(Map<String,Object> map);
	List<Business> listByCondition(Map<String,Object> map);
	Business getByPKey(String seq);
	int create(Business business);
	int insert(Business business);
	int update(Business business);
	int delete(String seq);
}
