package org.kh.test.ano;

import org.springframework.stereotype.Component;

@Component("white")
public class WhiteChocolate implements Chocolate{
	@Override
	public void baeByungChook() {
		System.out.println("백조 배병축");
	}
	
	@Override
	public void byungChookBae() {
		System.out.println("세상에......2");
	}
}
