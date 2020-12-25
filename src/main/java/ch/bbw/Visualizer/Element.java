package ch.bbw.Visualizer;

import java.util.ArrayList;

public class Element {
	private String elementString;
	private String valueForOrder;
	private ArrayList<Element> childrenElementList = new ArrayList<Element>();

	public String getElementString() {
		return elementString;
	}

	public void setElementString(String elementString) {
		this.elementString = elementString;
	}

	public void addChildrenElement(Element element) {
		childrenElementList.add(element);
	}

	public ArrayList<Element> getChildrenElementList() {
		return childrenElementList;
	}

	public void setChildrenElementList(ArrayList<Element> childrenElementList) {
		this.childrenElementList = childrenElementList;
	}

	public String getValueForOrder() {
		return valueForOrder;
	}

	public void setValueForOrder(String valueForOrder) {
		this.valueForOrder = valueForOrder;
	}

	@Override
	public String toString() {
		return "Element [elementString=" + elementString + ", valueForOrder=" + valueForOrder + ", childrenElementList="
				+ childrenElementList + "]";
	}
	
	
}
