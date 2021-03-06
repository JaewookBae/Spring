package polymorphism;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component - 잘 안씀
//@Controller - MVC에서 Controller에 해당하는 것
//@Service - MVC에서 Model(비지니스 로직..코어 로직)
//@Repository - DB연동 객체 (잘 안씀 : DB연동을 다른 프레임 워크를 사용하기때문)
public class SonySpeaker implements Speaker{

	public SonySpeaker() {
		System.out.println("[<-소니 스피커 생성자 호출됨->]");
	}
	
	public void volumeUp() {
		System.out.println("[소니 스피커] 소리를 올린다.");
	}

	public void volumeDown() {
		System.out.println("[소니 스피커] 소리를 내린다.");		
	}

}
