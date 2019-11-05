package org.kh.test.ano;

import org.springframework.stereotype.Component;

@Component("dark")
public class DarkChocolate implements Chocolate{
	@Override
	public void baeByungChook() {
		System.out.println("흑표범 배병축");
	}
	
	@Override
	public void byungChookBae() {
		System.out.println("세상에......1");
	}
}
