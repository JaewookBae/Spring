package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {

	@Autowired // DI - Setter 주입 : 가장 많이 쓰는 핵심
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("[<-LG TV 생성자 호출됨->]");		
	}
	
	public void powerOn() {		
		System.out.println("[LG TV] 전원을 켠다.");
	}

	public void powerOff() {				
		System.out.println("[LG TV] 전원을 끈다.");
	}

	public void volumeUp() {			
		//System.out.println("[LG TV] 소리를 올린다.");
		speaker.volumeUp();
	}

	public void volumeDown() {			
		//System.out.println("[LG TV] 소리를 내린다.");
		speaker.volumeDown();
	}
}
