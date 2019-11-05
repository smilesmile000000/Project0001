package org.kh.exam;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	@Override
	public void speakerOn() {
		System.out.println("SONY ON");
	}
	
	@Override
	public void speakerOff() {
		System.out.println("SONY OFF");
	}
}
