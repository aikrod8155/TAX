package efia.tax.service;

import java.util.List;
import java.util.Map;

import efia.tax.entity.Business;

public interface BusinessService {
	int countByCondition(Map<String ,Object> query);
	List<Business>listByCondition(Map<String ,Object>query);
	Business getByPKey(String seq);
	int reset();
	int insert(Business business);
	int update(Business business);
	int delete(String seq);
}
