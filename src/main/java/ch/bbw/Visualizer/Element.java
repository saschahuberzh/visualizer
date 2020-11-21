package ch.bbw.Visualizer;

import java.util.ArrayList;

public class Element {
	private String element;
	private ArrayList<String> childrenElementList = new ArrayList<String>();

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public void addChildrenElement(String element) {
		childrenElementList.add(element);
	}
}
