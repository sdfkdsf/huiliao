package com.coinMall.pojo;

public class UserInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.uid
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.gold_total
     *
     * @mbg.generated
     */
    private Double goldTotal;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.uid
     *
     * @return the value of t_user_info.uid
     *
     * @mbg.generated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.uid
     *
     * @param uid the value for t_user_info.uid
     *
     * @mbg.generated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.gold_total
     *
     * @return the value of t_user_info.gold_total
     *
     * @mbg.generated
     */
    public Double getGoldTotal() {
        return goldTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.gold_total
     *
     * @param goldTotal the value for t_user_info.gold_total
     *
     * @mbg.generated
     */
    public void setGoldTotal(Double goldTotal) {
        this.goldTotal = goldTotal;
    }
}