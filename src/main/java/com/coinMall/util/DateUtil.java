package com.coinMall.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiao.huiyu
 * @date 2018年10月13日 新建
 */
public class DateUtil {
	/**
	 * 根据传入的日期格式化日期，返回yyyy-MM-dd HH:mm:ss
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 根据当前日期格式化日期，返回yyyy-MM-dd HH:mm:ss
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong() {
		Date dateDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 根据传入的日期格式化日期，返回yyyy-MM-dd
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrShort(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 根据当前日期格式化日期，返回yyyy-MM-dd
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrShort() {
		Date dateDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}
}
