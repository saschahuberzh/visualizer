package ch.bbw.Visualizer;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

public class ElementHistory {
	private ArrayList<Element> list = new ArrayList<Element>();

	public ArrayList<Element> getList() {
		return list;
	}

	public void setList(ArrayList<Element> list) {
		this.list = list;
	}
	
	public void addElement(Element element) {
		list.add(element);
	}
	
	public void addElementWith1Parent(int id, Element element) {
		list.get(id).addChildrenElement(element);
	}

	@Override
	public String toString() {
		return "ElementHistory [list=" + list + "]";
	}
	
	
}
