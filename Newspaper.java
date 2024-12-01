package quan_ly_sach;

public class Newspaper extends Document 
{
    private int day_release;
    
    public Newspaper() {}
    public Newspaper(String id, String name_nxb, int release_num, int day_release) 
    {
        super(id, name_nxb, release_num);
        this.day_release = day_release;
    }
    public void setDay_release(int day_release)
    {
        this.day_release = day_release;
    }
    public int getDay_release()
    {
        return this.day_release;
    }

    @Override
    public void display()
    {
        System.out.println("Newspaper: - Id: " + getId());
        System.out.println("           - NXB: " + getName_nxb());
        System.out.println("           - So ban phat hanh: " + getRealease_num());
        System.out.println("           - Ngay phat hanh: " + getDay_release());
    }
} 

/*package quan_ly_sach;

import javax.swing.JTextArea;

public class Newspaper extends Document 
{
    private int dayRelease;

    public Newspaper(String id, String nameNXB, int releaseNum, int dayRelease) {
        super(id, nameNXB, releaseNum);
        this.dayRelease = dayRelease;
    }

    @Override
    public void displayInfo(JTextArea textArea) {
        textArea.append("Newspaper ID: " + id + ", NXB: " + nameNXB + ", Release Number: " + releaseNum + ", Day Release: " + dayRelease);
    }
}
 */
