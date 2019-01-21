package com.coinMall.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.coinMall.bean.enums.UserConst;
import com.coinMall.pojo.ReceiptInfo;

/** 
 * @author jiangjiayi
 * @date 2018年10月16日
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-*.xml"})
public class ReceiptInfoMapperTest {
	
	@Autowired
	private ReceiptInfoMapper receiptInfoMapper;
	
	@Test
	public void getReceiptDefaultByUid() throws Exception{
		Integer uid = 1;
		ReceiptInfo receiptInfo = receiptInfoMapper.getReceiptDefaultByUid(uid);
		System.out.println(receiptInfo);
	}
	
	@Test
	public void updateByPrimaryKeySelective() throws Exception{
		ReceiptInfo record = new ReceiptInfo();
		record.setReceiptId(25);
		record.setReceiptDefault(UserConst.RECEIPT_DEFAULT_NO.getCode());//改为非默认
		int updateByPrimaryKeySelective = receiptInfoMapper.updateByPrimaryKeySelective(record);
	}
	
}
