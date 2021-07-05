package org.kokochi.common.domain;

import java.io.Serializable;

public class CodeLabelValue implements Serializable {

	private static final long serialVersionUID = 2046880741377457872L;
	
	private String label;
	private String value;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public CodeLabelValue(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
	public CodeLabelValue() {
		super();
	}
	@Override
	public String toString() {
		return "CodeLabelValue [label=" + label + ", value=" + value + "]";
	}
	
}
