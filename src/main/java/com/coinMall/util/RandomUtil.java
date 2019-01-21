package com.coinMall.util;

import java.math.BigDecimal;
/**
 * 随机数工具类
 * @author Wayne.M
 * 2018年10月24日
 */
public class RandomUtil {
	
	/**
	 * 随机生成区间范围内保留1位的浮点数
	 * @param min 最小值
	 * @param max 最大值
	 * @return
	 */
	public static double getDoubleRandomBetween(double min,double max) {
		double r =  min + (Math.random() * ((max - min)));
		BigDecimal b = new BigDecimal(r);
		return b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
}
