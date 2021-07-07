package polymorphism;

import org.springframework.stereotype.Component;

@Component
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		System.out.println("[<-애플 스피커 생성자 호출됨->]");
	}
	
	public void volumeUp() {
		System.out.println("[애플 스피커] 소리를 올린다.");
	}

	public void volumeDown() {
		System.out.println("[애플 스피커] 소리를 내린다.");		
	}

}
