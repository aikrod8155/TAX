package efia.tax.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import efia.tax.entity.Business;
import efia.tax.service.BusinessService;
import efia.tax.web.form.BusinessBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Controller
@Api(tags="TAX API")
public class BusinessController {
	
	@Autowired
	private BusinessService businessService;
	
	
	
	
	@ApiResponses(value= {
			@ApiResponse(code=500,message="�d�߲��`"),
			@ApiResponse(code=200,message="�d�ߦ��\"),
	})
	@ApiOperation(value="�̲νs�d�߸��")
	@RequestMapping(value="/show/{seq}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity <BusinessBean> getByPKey(@ApiParam(value="�Τ@�s��" )
							@PathVariable("seq") String seq){
		
		Business entity =businessService.getByPKey(seq);
		if(entity!=null) {
			return ResponseEntity.ok(new BusinessBean(entity));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
	
	
	@ApiResponses(value= {
			@ApiResponse(code=500,message="�d�߲��`"),
			@ApiResponse(code=200,message="�d�ߦ��\"),
	})
	@ApiOperation(value="�̱���d�߸��")
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<BusinessBean>> listByCondition(
			@ApiParam(value="�Ҧb����",required=false ,allowableValues="�򶩥�,�O�_��,�s�_��,��饫,�s�˥�,�s�˿�,�]�߿�,�x����,���ƿ�,�n�뿤,�x�n��,������,�̪F��,�y����,�Ὤ��,�x�F��,���,������,�s����")
			@RequestParam(value="city", required=false) String city,
			@ApiParam(value="�a�}",required=false )
			@RequestParam(value="address", required=false) String address,
			@ApiParam(value="�Τ@�s��",required=false )
			@RequestParam(value="seq", required=false) String seq,
			@ApiParam(value="�`���νs",required=false )
			@RequestParam(value="head", required=false) String head,
			@ApiParam(value="���q�W��",required=false )
			@RequestParam(value="name", required=false) String name,
			@ApiParam(value="�ꥻ�B",required=false )
			@RequestParam(value="capital", required=false) String capital,
			@ApiParam(value="�Хߤ��",required=false )
			@RequestParam(value="founding", required=false) String founding,
			@ApiParam(value="�O�_�ϥβΤ@�o��",required=false ,allowableValues="Y,N")
			@RequestParam(value="receipt", required=false) String receipt,
			@ApiParam(value="��~�N��",required=false )
			@RequestParam(value="typeCode1", required=false) String typeCode1,
			@ApiParam(value="��~�W��",required=false )
			@RequestParam(value="typeName1", required=false) String typeName1,
			@ApiParam(value="����^�Ǹ�Ƶ���", defaultValue="100", example="100", required=false) 
			@RequestParam(value="limit", required=false) Integer limit,
            @ApiParam(value="�q�ĴX���}�l�^��,�i�Plimit�ϥιF������ت�", defaultValue="0", example="0", required=false) 
			@RequestParam(value="offset", required=false) Integer offset
			
			){
	
		Map<String,Object> query=getQuery(address,seq,head,name,capital,founding,receipt,typeCode1,typeName1,limit,offset,city);
		List<Business> entitys=businessService.listByCondition(query);
		if(entitys==null || entitys.size()==0) {
			return ResponseEntity.notFound().build();
		}
		List<BusinessBean> entityBeans=new ArrayList<BusinessBean>();
		for(Business entity:entitys) {
			entityBeans.add(new BusinessBean(entity));
		}
		return ResponseEntity.ok(entityBeans);
	}
	@ApiResponses(value= {
			@ApiResponse(code=500,message="�d�߲��`"),
			@ApiResponse(code=200,message="�d�ߦ��\"),
	})
	@ApiOperation(value="�s�W")
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> InsertByCondition(
			@ApiParam(value="�a�}",required=false )
			@RequestParam(value="address", required=false) String address,
			@ApiParam(value="�Τ@�s��",required=false )
			@RequestParam(value="seq", required=false) String seq,
			@ApiParam(value="�`���νs",required=false )
			@RequestParam(value="head", required=false) String head,
			@ApiParam(value="���q�W��",required=false )
			@RequestParam(value="name", required=false) String name,
			@ApiParam(value="�ꥻ�B",required=false )
			@RequestParam(value="capital", required=false) String capital,
			@ApiParam(value="�Хߤ��",required=false )
			@RequestParam(value="founding", required=false) String founding,
			@ApiParam(value="�O�_�ϥβΤ@�o��",required=false ,allowableValues="Y,N")
			@RequestParam(value="receipt", required=false) String receipt,
			@ApiParam(value="��~�N��",required=false )
			@RequestParam(value="typeCode1", required=false) String typeCode1,
			@ApiParam(value="��~�W��",required=false )
			@RequestParam(value="typeName1", required=false) String typeName1,
			@ApiParam(value="��~�N��",required=false )
			@RequestParam(value="typeCode2", required=false) String typeCode2,
			@ApiParam(value="��~�W��",required=false )
			@RequestParam(value="typeName2", required=false) String typeName2,
			@ApiParam(value="��~�N��",required=false )
			@RequestParam(value="typeCode3", required=false) String typeCode3,
			@ApiParam(value="��~�W��",required=false )
			@RequestParam(value="typeName3", required=false) String typeName3,
			@ApiParam(value="��~�N��",required=false )
			@RequestParam(value="typeCode4", required=false) String typeCode4,
			@ApiParam(value="��~�W��",required=false )
			@RequestParam(value="typeName4", required=false) String typeName4
			
			){
	
		Business business=setQuery(address,seq,head,name,capital,founding,receipt,typeCode1,typeName1,typeCode2,typeName2,typeCode3,typeName3,typeCode4,typeName4);
		int entitys=businessService.insert(business);
		if(entitys==0 ) {
			return ResponseEntity.notFound().build();
		}
		//List<BusinessBean> entityBeans=new ArrayList<BusinessBean>();
		
			//entityBeans.add(new BusinessBean(business));
		
		return ResponseEntity.ok(entitys);
	}
	
	
	private Map<String,Object> getQuery(String address,String seq,String head,String name,String capital,String founding,String receipt,String typeCode1,String typeName1,Integer limit,Integer offset,String city){
		Map<String,Object> query=new HashMap<String,Object>();
		if(StringUtils.isNotBlank(city)) {
			query.put("address", city+"%");
		}
		if(StringUtils.isNotBlank(address)) {
			query.put("address", "%"+address+"%");
		}
		if(StringUtils.isNotBlank(address) && StringUtils.isNotBlank(city)) {
			query.put("address", city+address+"%");
		}
		if(StringUtils.isNotBlank(seq)) {
			query.put("seq", seq);
		}
		if(StringUtils.isNotBlank(head)) {
			query.put("head", head);
		}
		if(StringUtils.isNotBlank(name)) {
			query.put("name", name);
		}
		if(StringUtils.isNotBlank(capital)) {
			query.put("capital", capital);
		}
		if(StringUtils.isNotBlank(founding)) {
			query.put("founding", founding);
		}
		if(StringUtils.isNotBlank(receipt)) {
			query.put("receipt", receipt);
		}
		if(StringUtils.isNotBlank(typeCode1)) {
			query.put("typeCode1", typeCode1);
			//query.put("typeCode2", typeCode1);
			//query.put("typeCode3", typeCode1);
		}
		if(StringUtils.isNotBlank(typeName1)) {
			query.put("typeName1", typeName1);
			//query.put("typeName2", typeName1);
			//query.put("typeName3", typeName1);
		}
		if(offset==null)
			offset=0;
		query.put("limit", limit);
		query.put("offset", offset);
		return query;
	}
	
	
	
	
	
	
	private Business setQuery(String address,String seq,String head,String name,String capital,String founding,String receipt,String typeCode1,String typeName1,String typeCode2,String typeName2,String typeCode3,String typeName3,String typeCode4,String typeName4){
		Business business=new Business();
		business.setAddress(address);
		business.setSeq(seq);
		business.setHead(head);
		business.setName(name);
		business.setCapital(capital);
		business.setFounding(founding);
		business.setReceipt(receipt);
		business.setTypeCode1(typeCode1);
		business.setTypeName1(typeName1);
		business.setTypeCode2(typeCode2);
		business.setTypeName2(typeName2);
		business.setTypeCode3(typeCode3);
		business.setTypeName3(typeName3);
		business.setTypeCode4(typeCode4);
		business.setTypeName4(typeName4);
		
		return business;
	}
	
	
	
	
	
	
	
	
	
}
