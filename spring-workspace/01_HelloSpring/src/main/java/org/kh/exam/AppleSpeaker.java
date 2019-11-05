package org.kh.exam;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{
	@Override
	public void speakerOn() {
		System.out.println("APPLE ON");
	}
	
	@Override
	public void speakerOff() {
		System.out.println("APPLE OFF");
	}
}
