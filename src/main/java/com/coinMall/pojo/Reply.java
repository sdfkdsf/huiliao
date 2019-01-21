package com.coinMall.pojo;

import java.util.Date;

public class Reply {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.reply_id
     *
     * @mbg.generated
     */
    private Long replyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.comment_id
     *
     * @mbg.generated
     */
    private Long commentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.atUid
     *
     * @mbg.generated
     */
    private Integer atuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.reply_content
     *
     * @mbg.generated
     */
    private String replyContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.reply_time
     *
     * @mbg.generated
     */
    private Date replyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.reply_images
     *
     * @mbg.generated
     */
    private String replyImages;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.reply_ip
     *
     * @mbg.generated
     */
    private String replyIp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.ip_area
     *
     * @mbg.generated
     */
    private String ipArea;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.reply_status
     *
     * @mbg.generated
     */
    private Integer replyStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.reply_total
     *
     * @mbg.generated
     */
    private Integer replyTotal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_reply.praise_total
     *
     * @mbg.generated
     */
    private Integer praiseTotal;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.reply_id
     *
     * @return the value of t_reply.reply_id
     *
     * @mbg.generated
     */
    public Long getReplyId() {
        return replyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.reply_id
     *
     * @param replyId the value for t_reply.reply_id
     *
     * @mbg.generated
     */
    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.comment_id
     *
     * @return the value of t_reply.comment_id
     *
     * @mbg.generated
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.comment_id
     *
     * @param commentId the value for t_reply.comment_id
     *
     * @mbg.generated
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.atUid
     *
     * @return the value of t_reply.atUid
     *
     * @mbg.generated
     */
    public Integer getAtuid() {
        return atuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.atUid
     *
     * @param atuid the value for t_reply.atUid
     *
     * @mbg.generated
     */
    public void setAtuid(Integer atuid) {
        this.atuid = atuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.reply_content
     *
     * @return the value of t_reply.reply_content
     *
     * @mbg.generated
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.reply_content
     *
     * @param replyContent the value for t_reply.reply_content
     *
     * @mbg.generated
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.reply_time
     *
     * @return the value of t_reply.reply_time
     *
     * @mbg.generated
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.reply_time
     *
     * @param replyTime the value for t_reply.reply_time
     *
     * @mbg.generated
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.reply_images
     *
     * @return the value of t_reply.reply_images
     *
     * @mbg.generated
     */
    public String getReplyImages() {
        return replyImages;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.reply_images
     *
     * @param replyImages the value for t_reply.reply_images
     *
     * @mbg.generated
     */
    public void setReplyImages(String replyImages) {
        this.replyImages = replyImages == null ? null : replyImages.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.reply_ip
     *
     * @return the value of t_reply.reply_ip
     *
     * @mbg.generated
     */
    public String getReplyIp() {
        return replyIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.reply_ip
     *
     * @param replyIp the value for t_reply.reply_ip
     *
     * @mbg.generated
     */
    public void setReplyIp(String replyIp) {
        this.replyIp = replyIp == null ? null : replyIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.ip_area
     *
     * @return the value of t_reply.ip_area
     *
     * @mbg.generated
     */
    public String getIpArea() {
        return ipArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.ip_area
     *
     * @param ipArea the value for t_reply.ip_area
     *
     * @mbg.generated
     */
    public void setIpArea(String ipArea) {
        this.ipArea = ipArea == null ? null : ipArea.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.reply_status
     *
     * @return the value of t_reply.reply_status
     *
     * @mbg.generated
     */
    public Integer getReplyStatus() {
        return replyStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.reply_status
     *
     * @param replyStatus the value for t_reply.reply_status
     *
     * @mbg.generated
     */
    public void setReplyStatus(Integer replyStatus) {
        this.replyStatus = replyStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.reply_total
     *
     * @return the value of t_reply.reply_total
     *
     * @mbg.generated
     */
    public Integer getReplyTotal() {
        return replyTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.reply_total
     *
     * @param replyTotal the value for t_reply.reply_total
     *
     * @mbg.generated
     */
    public void setReplyTotal(Integer replyTotal) {
        this.replyTotal = replyTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_reply.praise_total
     *
     * @return the value of t_reply.praise_total
     *
     * @mbg.generated
     */
    public Integer getPraiseTotal() {
        return praiseTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_reply.praise_total
     *
     * @param praiseTotal the value for t_reply.praise_total
     *
     * @mbg.generated
     */
    public void setPraiseTotal(Integer praiseTotal) {
        this.praiseTotal = praiseTotal;
    }
}