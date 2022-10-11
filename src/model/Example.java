package model;

import java.io.Serializable;
import java.util.Objects;

public class Example implements Serializable{

	private static final long serialVersionUID = 1L;
	String string;

// constructor vacio
	public Example() {
		
	}

// metodo toString
	@Override
	public String toString() {
		return "Example [toString()=" + super.toString() + "]";
	}

// metodo equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Example other = (Example) obj;
		return Objects.equals(string, other.string);
	}

	
	
}
