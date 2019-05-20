package pack;

import javax.ejb.Remote;


@Remote
public class Indicateur{
	
	boolean nvMessage;
	
	public Indicateur(){
		nvMessage = false;
	}

	public void setnvMessage(boolean b){
		nvMessage = b;
	}
	
	public boolean getnvMessage(){
		return nvMessage;
	}


}
