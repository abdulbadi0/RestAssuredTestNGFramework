package apiTestClasses;

public class PostsFirstClass {

	private int id;
	private String title;
	private String author;

	public int getID() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setID(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PostsFirstClass [id=" + id + ", title=" + title + ", author=" + author + "]";
	}

}
