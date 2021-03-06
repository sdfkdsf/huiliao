package com.coinMall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.coinMall.pojo.GoldLog;

public interface GoldLogMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_gold_log
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Long obtainId);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_gold_log
	 * @mbg.generated
	 */
	int insert(GoldLog record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_gold_log
	 * @mbg.generated
	 */
	int insertSelective(GoldLog record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_gold_log
	 * @mbg.generated
	 */
	GoldLog selectByPrimaryKey(Long obtainId);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_gold_log
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(GoldLog record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_gold_log
	 * @mbg.generated
	 */
	int updateByPrimaryKey(GoldLog record);
	
	/**
     * 查询统计赠送金币次数
     * @param uid
     * @param rule_id
     * @return
     */
    int getLogCountByUserRuleIdTime(@Param("uid")Integer uid, @Param("rule_id")Integer rule_id,@Param("now_time")String now_time);
    /**
     * 统计相同规则下的金币赠送均值
     * @param rule_id
     * @return
     */
    double getLogAvgByRuleId(@Param("rule_id")Integer rule_id);
    /**
     * 根据用户ID分页查询金币赠送日志
     * @param uid
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<GoldLog> getGoldLogOfPage(@Param("uid")Integer uid,@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
    /**
     * 根据用户ID统计赠送次数
     * @param uid
     * @return
     */
    int getGoldLogCountByUserId(@Param("uid")Integer uid);
}