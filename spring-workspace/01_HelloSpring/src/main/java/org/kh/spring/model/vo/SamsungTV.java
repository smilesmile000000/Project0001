package org.kh.spring.model.vo;

public class SamsungTV implements TV {
	
	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성 완료");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void powerOn() {
		System.out.println("SamsungTV ---- 전원 켜짐");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV ---- 전원 꺼짐");
	}
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV ---- 소리를 올림");
	}
	@Override
	public void volumeDown() {
		System.out.println("SamsungTV ---- 소리를 내림");
	}
}
