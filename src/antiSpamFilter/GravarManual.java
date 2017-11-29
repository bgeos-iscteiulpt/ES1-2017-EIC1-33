package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GravarManual implements ActionListener {
		private Gui_Cliente gui;
		private String[] val = new String[335];
	public GravarManual(Gui_Cliente gui){
		this.gui=gui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			int g=0;
			boolean ilegal= false;
			for (String line : gui.getBoxrightmanual().getText().split("\n")){
				String[] parts = line.split("->");
				val[g]=parts[1];
				g++;
				//ver se é de -5 a 5
				double value = Double.parseDouble(parts[1]);
				if(value <-5 || value >5)
					ilegal=true;
				//----------------
			}
			
			if(!ilegal){
			PrintWriter writer = new PrintWriter("Ficheiros/manConf.txt");
			for(int i=0; i<335; i++){
				writer.println(val[i]);
			}
			writer.close();
			}
		
			} catch (FileNotFoundException e) {
			}
		
	}
	
}
