package antiSpamFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;

public class AvaliarManual implements ActionListener {
	
	private static ArrayList<String> mspam = ReadFiles.getSpam();
	private static ArrayList<String> mham = ReadFiles.getHam();
	private static ArrayList<String> mrules = ReadFiles.getRules();
	private String[] mval = new String[335];
	private Gui_Cliente gui;
	
	public AvaliarManual(Gui_Cliente gui){
		this.gui=gui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int t=0;
		Scanner s = new Scanner("Ficheiros/manConf.txt");
		File file = new File(s.nextLine());
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (s.hasNext()) {
			String line = s.nextLine();	
			mval[t]=line;
			t++;
		}
		
		int fn=0;
		for(String w:mspam){
			double count=0;
			String[] parts = w.split("	");
			for(int v=1;v<parts.length;v++){
				for(String u:mrules){
					if(u.equals(parts[v]))
						count=count+(Double.parseDouble(mval[mrules.indexOf(u)]));
				}	
			}
			if (count<5)
				fn++;
		} 
		gui.getFN1().setText("FN: "+fn);
		
		int fp=0;
		for(String w:mham){
			double count=0;
			String[] parts = w.split("	");
			for(int v=1;v<parts.length;v++){
				for(String u:mrules){
					if(u.equals(parts[v]))
						count=count+(Double.parseDouble(mval[mrules.indexOf(u)]));
				}
			}
			if (count>5)
				fp++;
		} 
		gui.getFP1().setText("FP: "+fp);
		
	}}
