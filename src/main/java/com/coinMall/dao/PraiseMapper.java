package com.coinMall.dao;

import org.apache.ibatis.annotations.Param;

import com.coinMall.pojo.Praise;

public interface PraiseMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_praise
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Long praiseId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_praise
	 * @mbg.generated
	 */
	int insert(Praise record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_praise
	 * @mbg.generated
	 */
	int insertSelective(Praise record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_praise
	 * @mbg.generated
	 */
	Praise selectByPrimaryKey(Long praiseId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_praise
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(Praise record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_praise
	 * @mbg.generated
	 */
	int updateByPrimaryKey(Praise record);

	/**
     * 根据用户ID，评论ID，类型删除记录
     * @param commentId
     * @param uid
     * @param praiseType
     * @return
     */
    int deleteRecord(@Param("commentId")Long commentId, @Param("uid")Integer uid, @Param("praiseType")Integer praiseType);
}