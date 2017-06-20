package com.taotao.pojo;

import java.io.Serializable;

public class EasyUITreeNode implements Serializable {
	// 节点ID
	private Long id;
	// 节点名称
	private String text;
	// 节点状态 有子节点为 “closed” 没有节点为 “open”
	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
