package org.kh.exam;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("com")
public class Computer {
	@Resource(name="sony")
	Speaker speaker;

	public Computer() {
		super();
		System.out.println("SPEAKER ON");
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
}
