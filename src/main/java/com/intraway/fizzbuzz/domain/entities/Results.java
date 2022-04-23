package com.intraway.fizzbuzz.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "results")
public class Results implements Serializable {

	private static final long serialVersionUID = 3L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_result", unique = true, nullable = false, precision = 10)
	private int idResult;
	@Column(name = "value", nullable = false, length = 8)
	private String value;
	@ManyToOne(optional = false)
	@JoinColumn(name = "fk_id_ok_invocation", nullable = false)
	private OkInvocations okInvocation;

	/**
	 * GET idResult.
	 *
	 * @return valor actual de idResult
	 */
	public int getIdResult() {
		return idResult;
	}

	/**
	 * SET idResult.
	 *
	 * @param valor de idResult
	 */
	public void setIdResult(int aIdResult) {
		idResult = aIdResult;
	}

	/**
	 * GET value.
	 *
	 * @return valor actual de value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * SET value.
	 *
	 * @param valor de value
	 */
	public void setValue(String aValue) {
		value = aValue;
	}

	/**
	 * GET okInvocations.
	 *
	 * @return valor actual de okInvocations
	 */
	public OkInvocations getOkInvocation() {
		return okInvocation;
	}

	/**
	 * SET okInvocations.
	 *
	 * @param valor de okInvocations
	 */
	public void setOkInvocation(OkInvocations aOkInvocation) {
		okInvocation = aOkInvocation;
	}

}
