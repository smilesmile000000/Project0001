package org.kh.test.ano;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("saga")
public class CandyCruchSaga {
	@Resource(name="dark")
	Chocolate choco;
	
	public CandyCruchSaga() {
		super();
		System.out.println("KING");
	}
	public Chocolate getChoco() {
		return choco;
	}
	public void setChoco(Chocolate choco) {
		this.choco = choco;
	}
	
}
