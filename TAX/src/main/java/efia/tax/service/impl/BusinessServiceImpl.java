package efia.tax.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import efia.tax.dao.BusinessDao;
import efia.tax.entity.Business;
import efia.tax.service.BusinessService;

@Service("BusinessService")
public class BusinessServiceImpl implements BusinessService{
	@Autowired
	private BusinessDao businessDao;

	public int countByCondition(Map<String, Object> query) {
		return businessDao.coutByCondition(query);
	}

	public List<Business> listByCondition(Map<String, Object> query) {
		Map<String,Object> map=new HashMap<String,Object>(query);
		return businessDao.listByCondition(map);
	}

	public int reset() {
		int row=0;
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(BusinessServiceImpl.class.getResourceAsStream("/t_business.csv"),"UTF-8"));
			String line=null;
			line=reader.readLine();
			while((line=reader.readLine())!=null) {
				
				while(line.indexOf(",,")>-1) {
					line=line.replace(",,", ",N/A,");
					
				}
				line=line.concat("N/A");
				String []rows=line.split(",");
				Business entity=new Business(rows[0],rows[1],rows[2],rows[3],rows[4],rows[5],rows[6],rows[7],rows[8],rows[9],rows[10],rows[11],rows[12],rows[13],rows[14]);
				row+=businessDao.create(entity);
				}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return row;
	}

	public Business getByPKey(String seq) {
		return businessDao.getByPKey(seq);
	}

	public int insert(Business business) {
		return businessDao.insert(business);
	}

	public int update(Business business) {
		return businessDao.update(business);
	}

	public int delete(String seq) {
		return businessDao.delete(seq);
	}
	
	

}
