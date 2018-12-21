package efia.tax.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import efia.tax.dao.DataDao;
import efia.tax.entity.Business;
import efia.tax.service.BusinessService;
import efia.tax.service.DataService;
import efia.tax.util.DbUtil;

@Service("DataService")
public class DataServiceImpl implements DataService{
	@Autowired
	private DataDao dataDao;
	@Autowired
	private BusinessService businessService;
	@Autowired
	private DataSource dataSource;

	public void init() {
		boolean tableExist=this.checkTableExist("t_business");
		if(!tableExist) {
			try {
			DbUtil.execute(dataSource,DataServiceImpl.class.getResourceAsStream("/sql/t_business.sql"));
			businessService.reset();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public boolean checkTableExist(String tableName) {
		return checkTableExist(null, tableName);
	}

	public boolean checkTableExist(String dbName, String tableName) {
		Map<String,Object>map=new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(dbName)) {
			map.put("dbname", dbName);
		}
		map.put("tableName", tableName);
		return(dataDao.countByTable(map)>0);
	}

	

}
