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
			@ApiResponse(code=500,message="查詢異常"),
			@ApiResponse(code=200,message="查詢成功"),
	})
	@ApiOperation(value="依統編查詢資料")
	@RequestMapping(value="/business/{seq}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity <BusinessBean> getByPKey(@ApiParam(value="統一編號" )
							@PathVariable("seq") String seq){
		
		Business entity =businessService.getByPKey(seq);
		if(entity!=null) {
			return ResponseEntity.ok(new BusinessBean(entity));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
	
	
	@ApiResponses(value= {
			@ApiResponse(code=500,message="查詢異常"),
			@ApiResponse(code=200,message="查詢成功"),
	})
	@ApiOperation(value="依條件查詢資料")
	@RequestMapping(value="/business", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<BusinessBean>> listByCondition(
			@ApiParam(value="地址",required=false )
			@RequestParam(value="address", required=false) String address,
			@ApiParam(value="統一編號",required=false )
			@RequestParam(value="seq", required=false) String seq,
			@ApiParam(value="總部統編",required=false )
			@RequestParam(value="head", required=false) String head,
			@ApiParam(value="公司名稱",required=false )
			@RequestParam(value="name", required=false) String name,
			@ApiParam(value="資本額",required=false )
			@RequestParam(value="capital", required=false) String capital,
			@ApiParam(value="創立日期",required=false )
			@RequestParam(value="founding", required=false) String founding,
			@ApiParam(value="是否使用統一發票",required=false ,allowableValues="Y,N")
			@RequestParam(value="receipt", required=false) String receipt,
			@ApiParam(value="行業代號",required=false )
			@RequestParam(value="typeCode1", required=false) String typeCode1,
			@ApiParam(value="行業名稱",required=false )
			@RequestParam(value="typeName1", required=false) String typeName1,
			@ApiParam(value="限制回傳資料筆數", defaultValue="100", example="100", required=false) 
			@RequestParam(value="limit", required=false) Integer limit,
            @ApiParam(value="從第幾筆開始回傳,可與limit使用達到分頁目的", defaultValue="0", example="0", required=false) 
			@RequestParam(value="offset", required=false) Integer offset
			
			){
	
		Map<String,Object> query=getQuery(address,seq,head,name,capital,founding,receipt,typeCode1,typeName1,limit,offset);
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
	
	
	private Map<String,Object> getQuery(String address,String seq,String head,String name,String capital,String founding,String receipt,String typeCode1,String typeName1,Integer limit,Integer offset){
		Map<String,Object> query=new HashMap<String,Object>();
		if(StringUtils.isNotBlank(address)) {
			query.put("address", "%"+address+"%");
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
	
}
