package LibraryManagement;

public class Books {
    private String title;
    private String author;
    private int ISBN;
    private boolean isBorrowed;
    // private static int count;

    public Books(String title, String author, int ISBN, boolean isBorrowed){
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
        this.isBorrowed=isBorrowed;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getISBN(){
        return ISBN;
    }

    public boolean getIsBorrowed(){
        return isBorrowed;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setAuthor(String author){
        this.author=author;
    }

    public void setISBN(int ISBN){
        this.ISBN=ISBN;
    }

    public void setIsBorrowed(boolean isBorrowed){
        this.isBorrowed=isBorrowed;
    }

    public String toString(){
        return "\t\t" + title + "\t\t" + author + "\t\t" + ISBN + "\t\t" + isBorrowed;
    }

}
