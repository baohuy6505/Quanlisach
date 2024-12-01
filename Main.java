package quan_ly_sach;
import java.util.Scanner;

public class Main 
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        DocumentManagement xaptailieu1 = new DocumentManagement();
        boolean exit = false;

        while (!exit)
        {
            System.out.println("1/ Them tai lieu");
            System.out.println("2/ Xoa tai lieu");
            System.out.println("3/ Hien thi thong tin ve tai lieu");
            System.out.println("4/ Hien thi tai lieu theo loai");
            System.out.println("5/ Thoat");
            System.out.println();
            System.out.print("Your option: ");
            int option = scan.nextInt();
            scan.nextLine();

            switch (option) 
            {
               case 1: 
               {
                    boolean exit1 = false;
                    while (!exit1)
                    {
                        System.out.println("a/ Them sach vao tai lieu");
                        System.out.println("b/ Them tap chi vao tai lieu");
                        System.out.println("c/ Them bao vao tai lieu");
                        System.out.println("d/ Thoat");
                        System.out.println();
                        System.out.print("Your option: ");
                        String option1 =  scan.nextLine();

                        switch (option1)
                        {
                            case "a":
                            {
                                System.out.print(" - Nhap ma tai lieu: ");
                                String id = scan.nextLine();
                                System.out.print(" - Nhap nha xuat ban: ");
                                String name_nxb = scan.nextLine();
                                System.out.print(" - Nhap so luong phat hanh: ");
                                int release_num = scan.nextInt();
                                scan.nextLine();
                                System.out.print(" - Nhap tac gia: ");
                                String name_author = scan.nextLine();
                                System.out.print(" - Nhap so trang: ");
                                int num_page = scan.nextInt();
                                scan.nextLine();
                                Document doc = new Book(id, name_nxb, release_num, name_author, num_page);
                                xaptailieu1.addDocument(doc);
                                break;
                            }
                            case "b":
                            {
                                System.out.print(" - Nhap ma tai lieu: ");
                                String id = scan.nextLine();
                                System.out.print(" - Nhap nha xuat ban: ");
                                String name_nxb = scan.nextLine();
                                System.out.print(" - Nhap so luong phat hanh: ");
                                int release_num = scan.nextInt();
                                scan.nextLine();
                                System.out.print(" - Nhap ma phat hanh: ");
                                int id_release = scan.nextInt();
                                scan.nextLine();
                                System.out.print(" - Nhap thang phat hanh: ");
                                int month_release = scan.nextInt();
                                scan.nextLine();
                                Document doc = new Magezine(id, name_nxb, release_num, id_release, month_release);
                                xaptailieu1.addDocument(doc);
                                break;
                            }
                            case "c":
                            {
                                System.out.print(" - Nhap ma tai lieu: ");
                                String id = scan.nextLine();
                                System.out.print(" - Nhap nha xuat ban: ");
                                String name_nxb = scan.nextLine();
                                System.out.print(" - Nhap so luong phat hanh: ");
                                int release_num = scan.nextInt();
                                scan.nextLine();
                                System.out.print(" - Nhap ngay phat hanh: ");
                                int day_release = scan.nextInt();
                                scan.nextLine();
                                Document doc = new Newspaper(id, name_nxb, release_num, day_release);
                                xaptailieu1.addDocument(doc);
                                break;
                            }
                            case "d":
                            {
                                exit1 = true;
                                break;
                            }
                        }
                    }
                    break;
               }
               case 2:
               {
                    System.out.print(" - Nhap ma tai lieu muon xoa: ");
                    String id = scan.nextLine();
                    if (xaptailieu1.removeDocument(id))
                    {
                        System.out.println(" - Xoa thanh cong!");
                    }
                    else
                    {
                        System.out.println(" - Xoa that bai!");
                    }
                    break;
               }
               case 3:
               {
                    xaptailieu1.displayDocument();
                    break;
               }
               case 4:
               {
                    boolean exit4 = false;
                    while (!exit4)
                    {
                        System.out.println("a/ Hien thi thong tin sach: ");
                        System.out.println("b/ Hien thi thong tin tap chi");
                        System.out.println("c/ Hien thi thong tin bao: ");
                        System.out.println("4/ Thoat");
                        System.out.println();
                        System.out.print("Your option: ");
                        String option4 = scan.nextLine();
                        
                        switch (option4) 
                        {
                           case "a":
                           {
                                xaptailieu1.searchByBooks();
                                break;
                           }
                           case "b":
                           {
                                xaptailieu1.searchByMagezine();
                                break;
                           }
                           case "c":
                           {
                                xaptailieu1.searchByNewspaper();
                                break;
                           }
                           case "d":
                           {
                                exit4 = true;
                                break;
                           }
                        }
                    }
                    break;
               }
               case 5:
               {
                    exit = true;
                    break;
               }
            }
            System.out.println("-------------------------------------------");
        }
        scan.close();
    }
}
