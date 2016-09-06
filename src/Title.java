
public class Title {

	private String file;
	
	private String name;
	
	private String color;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Title [file=" + file + ", name=" + name + ", color=" + color + "]";
	}
	
	
}
