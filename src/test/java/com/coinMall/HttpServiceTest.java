package com.coinMall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.coinMall.common.httpclient.HttpService;

/** 
 * @author jiangjiayi
 * @date 2018年10月13日
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-*.xml"})
public class HttpServiceTest {
	
	private static Logger logger = LoggerFactory.getLogger(HttpServiceTest.class);
	
	@Autowired
	private HttpService httpService;
	
	@Test
	public void doGet() throws Exception{
		String result = httpService.doGet("http://www.baidu.com");
		logger.debug(result);
		System.out.println(result);
	}

}
