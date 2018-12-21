package efia.tax.service;

public interface DataService {
	void init();
	boolean checkTableExist(String tableName);
	boolean checkTableExist(String dbName,String tableName);
	//boolean checkDBExist(String dbName);
}
