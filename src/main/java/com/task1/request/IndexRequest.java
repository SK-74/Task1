package com.task1.request;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Pattern;

public class IndexRequest {

	@Pattern(regexp="[0-9０-９]+", message = "数字を入力してください")
	@Range(min = 2, max = 100)
	private String value;

	/**
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param val セットする val
	 */
	public void setValue(String val) {
		this.value = val;
	}
}
