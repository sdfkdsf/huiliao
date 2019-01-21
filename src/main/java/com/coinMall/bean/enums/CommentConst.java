package com.coinMall.bean.enums;
/** 
 * 评论相关常量
 * @author jiangjiayi
 * @date 2018年10月16日
 */
public enum CommentConst {
	COMMENT_SOURCE_COINMALL(0, "金币商城"),
	PRAISE_YES(1, "点赞"), PRAISE_NO(0, "取消点赞"),
	COMMENT_TYPE_MAIN(1, "主评论"), COMMENT_TYPE_SUB(2, "子评论"),
	COMMENT_STATUS_DISPLAY_ON(0, "显示"), COMMENT_STATUS_DISPLAY_OFF(2, "不显示");
	
	private int code;
	private String text;
	
	CommentConst(int code, String text){
		this.code = code;
		this.text = text;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
