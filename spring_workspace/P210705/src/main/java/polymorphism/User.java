package polymorphism;

import org.springframework.context.support.GenericXmlApplicationContext;

public class User {

	public static void main(String[] args) {
		//Spring Container 가동
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("tttt.xml");
		
		
									//tttt.xml 파일명 입력
		TV tv = (TV) container.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}

}
