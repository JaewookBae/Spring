package polymorphism;

public class SamsungTV implements TV{

   private Speaker speaker;
   
   public SamsungTV() {
      System.out.println("[<-삼성 TV 생성자11111 호출됨->]");      
   }
   
   public SamsungTV(Speaker speaker) {
	   System.out.println("[<-삼성 TV 생성자22222 호출됨->]");
	   this.speaker = speaker;
   }
   
   //세터..
   public void setSpeaker(Speaker speaker) {
      System.out.println("세터 호출 돼?");
      this.speaker = speaker;
   }
   
   public void powerOn() {      
      System.out.println("[삼성 TV] 전원을 켠다.");
   }

   public void powerOff() {            
      System.out.println("[삼성 TV] 전원을 끈다.");
   }

   public void volumeUp() {         
      //System.out.println("[삼성 TV] 소리를 올린다.");
      speaker.volumeUp();
   }

   public void volumeDown() {         
      //System.out.println("[삼성 TV] 소리를 내린다.");
      speaker.volumeDown();
   }

   
}