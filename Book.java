package quan_ly_sach;

public class Book extends Document
{
    private String name_author;
    private int num_page;
    
    public Book() {}
    public Book(String id, String name_nxb, int release_num, String name_author, int num_page)
    {
        super(id, name_nxb, release_num);
        this.name_author = name_author;
        this.num_page = num_page;
    }
    public void setName_author(String name_author)
    {
        this.name_author = name_author;
    }
    public String getName_author()
    {
        return this.name_author;
    }
    public void setNum_page(int num_page)
    {
        this.num_page = num_page;
    }
    public int getNum_page()
    {
        return this.num_page;
    }

    @Override
    public void display()     
    {
        System.out.println("Book: - Id: " + getId());
        System.out.println("      - NXB: " + getName_nxb());
        System.out.println("      - So ban phat hanh:  " + getNum_page());
        System.out.println("      - Tac gia: " + getName_author());
        System.out.println("      - So trang: " + getNum_page());
    }
} 

/*package quan_ly_sach;

import javax.swing.JTextArea;

public class Book extends Document 
{
    private String author;
    private int numPage;

    public Book(String id, String nameNXB, int releaseNum, String author, int numPage) {
        super(id, nameNXB, releaseNum);
        this.author = author;
        this.numPage = numPage;
    }

    @Override
    public void displayInfo(JTextArea textArea) {
        textArea.append("Book ID: " + id + ", NXB: " + nameNXB + ", Release Number: " + releaseNum + ", Author: " + author + ", Number of Pages: " + numPage);
    }
} */

