package com.coinMall.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.coinMall.bean.out.user.UserSmallModel;
import com.coinMall.common.BaseService;

/** 
 * @author jiangjiayi
 * @date 2018年10月16日
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-*.xml"})
public class BaseServiceTest {
	
	@Autowired
	private BaseService baseService;
	
	@Test
	public void querySmallUserList() throws Exception{
		Collection<Integer> uids = new HashSet<>();
		uids.add(20163752);
		uids.add(20163742);
		List<UserSmallModel> list = baseService.querySmallUserList(uids);
		System.out.println(list);
	}
	
}
