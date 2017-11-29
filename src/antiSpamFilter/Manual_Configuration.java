package antiSpamFilter;


public class Manual_Configuration {
	private int[] valores = new int[335];
	
	public Manual_Configuration(){
		start();
	}
	
	public void start(){
		for (int i=0; i<335; i++){
			valores[i]=0;
		}
	}
	
	public int[] getValores() {
		return valores;
	}

	public void setValores(int[] valores) {
		this.valores = valores;
	}


}
