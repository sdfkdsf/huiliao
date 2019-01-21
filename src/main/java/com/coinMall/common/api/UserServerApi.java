package com.coinMall.common.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 
 * @author jiangjiayi
 * @date 2018年10月16日
 */
@Component
public class UserServerApi {
	
	@Value("${FX110_USER_SERVER_API}")
	private String baseUrl;
	
	public String getByUserId() {
		return baseUrl+"User/v1.1.1/GetByUserId";
	}
	
	public String queryUserList(){
		return baseUrl+"User/v1.1.1/QueryUserList";
	}
}
