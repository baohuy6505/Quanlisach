package quan_ly_sach;

public class Magezine extends Document
{
    private int id_release;
    private int month_release;
    
    public Magezine() {}
    public Magezine(String id, String name_nxb, int num_release, int id_release, int month_release)
    {
        super(id, name_nxb, num_release);
        this.id_release = id_release;
        this.month_release = month_release;
    }
    public void setId_release(int id_release)
    {
        this.id_release = id_release;
    }
    public int getId_release()
    {
        return this.id_release;
    }
    public void setMonth_release(int month_release)
    {
        this.month_release = month_release;
    }
    public int getMonth_release()
    {
        return this.month_release;
    }

    @Override
    public void display()
    {
        System.out.println("Magezine: - Id: " + getId());
        System.out.println("          - NXB: " + getName_nxb());
        System.out.println("          - So ban phat hanh: " + getRealease_num());
        System.out.println("          - So phat hanh: " + getId_release());
        System.out.println("          - Thang phat hanh: " + getMonth_release());
    }
} 

/*package quan_ly_sach;

import javax.swing.JTextArea;

public class Magezine extends Document {
    private int idRelease;
    private int monthRelease;

    public Magezine(String id, String nameNXB, int releaseNum, int idRelease, int monthRelease) {
        super(id, nameNXB, releaseNum);
        this.idRelease = idRelease;
        this.monthRelease = monthRelease;
    }

    @Override
    public void displayInfo(JTextArea textArea) {
        textArea.append("Magezine ID: " + id + ", NXB: " + nameNXB + ", Release Number: " + releaseNum + ", ID Release: " + idRelease + ", Month Release: " + monthRelease);
    }
}
*/
