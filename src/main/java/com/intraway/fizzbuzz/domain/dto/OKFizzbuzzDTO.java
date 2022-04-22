package com.intraway.fizzbuzz.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OKFizzbuzzDTO {

	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("code")
	private String code;
	@JsonProperty("description")
	private String description;
	@JsonProperty("list")
	private String list;
	@JsonIgnore
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String aTimestamp) {
		this.timestamp = aTimestamp;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String aCode) {
		this.code = aCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String aDescription) {
		this.description = aDescription;
	}

	public String getList() {
		return list;
	}

	public void setList(String aList) {
		this.list = aList;
	}

}
