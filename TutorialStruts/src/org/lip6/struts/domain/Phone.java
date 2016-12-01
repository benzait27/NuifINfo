package org.lip6.struts.domain;

public class Phone {
	
	private String Kind ; 
	private Long Num ; 


	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Phone(String Kind, Long Num ) 
    {
		this.Kind = Kind;
		this.Num = Num;

	}

	public String getKind() {
		return Kind;
	}

	public void setKind(String kind) {
		Kind = kind;
	}

	public Long getNum() {
		return Num;
	}

	public void setNum(Long num) {
		Num = num;
	} 
}
	
