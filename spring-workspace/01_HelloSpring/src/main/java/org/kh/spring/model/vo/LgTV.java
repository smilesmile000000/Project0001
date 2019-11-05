package org.kh.spring.model.vo;

public class LgTV implements TV {
	@Override
	public void powerOn() {
		System.out.println("LgTV ---- 전원 켜짐");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV ---- 전원 꺼짐");
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV ---- 소리를 올림");
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV ---- 소리를 내림");
	}
}
