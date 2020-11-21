package ch.bbw.Visualizer;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

public class ElementHistory {
	private ArrayList<String> list = new ArrayList<String>();

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	
	public void addElement(String element) {
		list.add(element);
	}
}
