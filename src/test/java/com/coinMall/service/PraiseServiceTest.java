package com.coinMall.service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.coinMall.bean.ReturnModel;

/** 
 * @author jiangjiayi
 * @date 2018年10月16日
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-*.xml"})
public class PraiseServiceTest {
	
	private static Logger logger = Logger.getLogger(PraiseServiceTest.class);

	@Autowired
	private PraiseService praiseService;
	
	@Test
	public void praiseComment(){
		Integer uid = 1;
		Long comment_id = 1L;
		Integer operateType = 0;//1-点赞，0-取消点赞
		Integer praiseType = 1;//1-主评论，2-副评论
		ReturnModel returnModel = praiseService.praiseComment(uid, comment_id, operateType, praiseType);
		logger.info(returnModel.toString());
	}
	
}
