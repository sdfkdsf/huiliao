package com.coinMall.dao;

import com.coinMall.pojo.GoldRule;

public interface GoldRuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gold_rule
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer ruleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gold_rule
     *
     * @mbg.generated
     */
    int insert(GoldRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gold_rule
     *
     * @mbg.generated
     */
    int insertSelective(GoldRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gold_rule
     *
     * @mbg.generated
     */
    GoldRule selectByPrimaryKey(Integer ruleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gold_rule
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(GoldRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gold_rule
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(GoldRule record);
}