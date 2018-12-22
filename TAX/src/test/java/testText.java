import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import efia.tax.entity.Business;
import efia.tax.service.BusinessService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:beans.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testText {
	@Autowired
	private BusinessService businessService;
	
	
	
	
	@Test
	public void test1(){
		// TODO Auto-generated method stub
		String t=",,,,java,,,,kk";
		t=t.replace(",,", ", ,");
		
		while(t.indexOf(",,")>-1) {
			t=t.replace(",,", ", ,");
		}
		System.out.println(t);
	}
	@Test
	public void testCreate() {
		Business business=new Business("aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron");
		int row=businessService.insert(business);
		System.out.println(row);
	}
	@Test
	public void testUpdate() {
		Business business=new Business("aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron","aaron2","aaron");
		int row=businessService.update(business);
		System.out.println(row);
	}
	@Test
	public void testDelete() {
		String seq="aaron";
		int row =businessService.delete(seq);
		System.out.println(row);
	}

}
