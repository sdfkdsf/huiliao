package com.coinMall.common.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 
 * @author jiangjiayi
 * @date 2018年10月16日
 */
@Component
public class BaseServerApi {

	@Value("${FX110_BASE_SERVER_API}")
	private String baseUrl;
	
	public String getLocation(){
		return baseUrl+"ip/getLocation";
	}
	
}
