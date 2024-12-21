package quan_ly_tai_lieu;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        DocumentManagement xaptailieu1 = new DocumentManagement();

        // Tao Map chua danh sach nguoi dung voi thong tin ten dang nhap, mat khau va quyen
        Map<String, User> users = new HashMap<>();
        users.put("Nhat Huy", new User("Nhat Huy", "nhathuy123", Role.ADMIN));  // Quan tri vien
        users.put("Bao Huy", new User("Bao Huy", "baohuy123", Role.ADMIN));      // Quan tri vien
        users.put("Trang", new User("Trang", "trang123", Role.USER));            // Nguoi dung
        users.put("Vu", new User("Vu", "vu123", Role.USER));                    // Nguoi dung
        users.put("Ha", new User("Ha", "ha123", Role.USER));                    // Nguoi dung
        users.put("Hao", new User("Hao", "hao123", Role.USER));                // Nguoi dung

        // Quan ly dang nhap
        User currentUser = null;
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            System.out.println("Dang nhap");
            System.out.print("Nhap ten nguoi dung: ");
            String username = scan.nextLine();
            System.out.print("Nhap mat khau: ");
            String password = scan.nextLine();

            // Kiem tra thong tin dang nhap
            if (users.containsKey(username)) {
                User user = users.get(username);
                if (user.authenticate(password)) {
                    currentUser = user;
                    isLoggedIn = true;
                    System.out.println("Dang nhap thanh cong voi quyen " + (currentUser.getRole() == Role.ADMIN ? "Quan tri vien" : "Nguoi dung"));
                } else {
                    System.out.println("Mat khau khong dung. Vui long thu lai.");
                }
            } else {
                System.out.println("Ten nguoi dung khong ton tai. Vui long thu lai.");
            }
        }

        // Chuong trinh menu chinh
        boolean exit = false;
        while (!exit) {
            System.out.println("1/ Them tai lieu");
            System.out.println("2/ Xoa tai lieu");
            System.out.println("3/ Hien thi thong tin tai lieu");
            System.out.println("4/ Hien thi tai lieu theo loai");
            System.out.println("5/ Thoat");

            // Chi hien thi tuy chon quan ly tai khoan nguoi dung neu la Admin
            if (currentUser.getRole() == Role.ADMIN) {
                System.out.println("6/ Quan ly tai khoan nguoi dung");
            }
            System.out.println();
            System.out.print("Chon chuc nang: ");
            int option = scan.nextInt();
            scan.nextLine();  // Consume newline character

            switch (option) {
                case 1: // Them tai lieu
                    if (currentUser.getRole() == Role.ADMIN) {
                        addDocument(scan, xaptailieu1);
                    } else {
                        System.out.println("Ban khong co quyen them tai lieu.");
                    }
                    break;

                case 2: // Xoa tai lieu
                    if (currentUser.getRole() == Role.ADMIN) {
                        deleteDocument(scan, xaptailieu1);
                    } else {
                        System.out.println("Ban khong co quyen xoa tai lieu.");
                    }
                    break;

                case 3: // Hien thi thong tin tai lieu
                    displayDocuments(xaptailieu1);
                    break;

                case 4: // Hien thi tai lieu theo loai
                    displayDocumentsByType(scan, xaptailieu1);
                    break;

                case 5: // Thoat
                    exit = true;
                    break;

                case 6: // Quan ly tai khoan nguoi dung (Admin only)
                    if (currentUser.getRole() == Role.ADMIN) {
                        manageUsers(scan);
                    } else {
                        System.out.println("Ban khong co quyen quan ly tai khoan nguoi dung.");
                    }
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
                    break;
            }
            System.out.println("-------------------------------------------");
        }
        scan.close();
    }

    private static void addDocument(Scanner scan, DocumentManagement xaptailieu1) {
        boolean exit1 = false; // Biến điều khiển vòng lặp cho menu thêm tài liệu
    
        while (!exit1) {
            System.out.println("a/ Them sach vao tai lieu");
            System.out.println("b/ Them tap chi vao tai lieu");
            System.out.println("c/ Them bao vao tai lieu");
            System.out.println("d/ Thoat");
            System.out.println();
            System.out.print("Chon chuc nang: ");
            String option1 = scan.nextLine();
    
            switch (option1) {
                case "a": {
                    System.out.print(" - Nhap ma tai lieu: ");
                    String id = scan.nextLine();
                    System.out.print(" - Nhap nha xuat ban: ");
                    String name_nxb = scan.nextLine();
                    System.out.print(" - Nhap so luong phat hanh: ");
                    int release_num = Integer.parseInt(scan.nextLine());  // Đọc số nguyên từ người dùng
                    System.out.print(" - Nhap ten sach: ");
                    String name_book = scan.nextLine();
                    System.out.print(" - Nhap tac gia: ");
                    String name_author = scan.nextLine();
                    System.out.print(" - Nhap so trang: ");
                    int num_page = Integer.parseInt(scan.nextLine());  // Đọc số nguyên từ người dùng
    
                    Document doc = new Book(id, name_nxb, release_num, name_book, name_author, num_page);
                    xaptailieu1.addDocument(doc);  // Thêm tài liệu vào danh sách quản lý
                    System.out.println("Them sach thanh cong!");
                    break;
                }
                case "b": {
                    System.out.print(" - Nhap ma tai lieu: ");
                    String id = scan.nextLine();
                    System.out.print(" - Nhap nha xuat ban: ");
                    String name_nxb = scan.nextLine();
                    System.out.print(" - Nhap so luong phat hanh: ");
                    int release_num = Integer.parseInt(scan.nextLine());  // Đọc số nguyên từ người dùng
                    System.out.print(" - Nhap ma phat hanh: ");
                    int id_release = Integer.parseInt(scan.nextLine());  // Đọc số nguyên từ người dùng
                    System.out.print(" - Nhap thang phat hanh: ");
                    int month_release = Integer.parseInt(scan.nextLine());  // Đọc số nguyên từ người dùng
    
                    Document doc = new Magezine(id, name_nxb, release_num, id_release, month_release);
                    xaptailieu1.addDocument(doc);  // Thêm tài liệu vào danh sách quản lý
                    System.out.println("Them tap chi thanh cong!");
                    break;
                }
                case "c": {
                    System.out.print(" - Nhap ma tai lieu: ");
                    String id = scan.nextLine();
                    System.out.print(" - Nhap nha xuat ban: ");
                    String name_nxb = scan.nextLine();
                    System.out.print(" - Nhap so luong phat hanh: ");
                    int release_num = Integer.parseInt(scan.nextLine());  // Đọc số nguyên từ người dùng
                    System.out.print(" - Nhap ngay phat hanh: ");
                    int day_release = Integer.parseInt(scan.nextLine());  // Đọc số nguyên từ người dùng
    
                    Document doc = new Newspaper(id, name_nxb, release_num, day_release);
                    xaptailieu1.addDocument(doc);  // Thêm tài liệu vào danh sách quản lý
                    System.out.println("Them bao thanh cong!");
                    break;
                }
                case "d": {
                    exit1 = true;  // Thoát khỏi menu thêm tài liệu
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le, chon lai!");
                    break;
                }
            }
        }
    }
    

    private static void deleteDocument(Scanner scan, DocumentManagement docManagement) {
        System.out.print("Nhap ma tai lieu muon xoa: ");
        String id = scan.nextLine();
        if (docManagement.removeDocument(id)) {
            System.out.println("Xoa tai lieu thanh cong!");
        } else {
            System.out.println("Xoa tai lieu that bai!");
        }
    }

    private static void displayDocuments(DocumentManagement docManagement) {
        docManagement.displayDocument();
    }

    private static void displayDocumentsByType(Scanner scan, DocumentManagement docManagement) {
        boolean exit = false;
        while (!exit) {
            System.out.println("a/ Hien thi sach");
            System.out.println("b/ Hien thi tap chi");
            System.out.println("c/ Hien thi bao");
            System.out.println("d/ Thoat");
            System.out.print("Chon loai tai lieu can hien thi: ");
            String option = scan.nextLine();

            switch (option) {
                case "a":
                    docManagement.searchByBooks();
                    break;
                case "b":
                    docManagement.searchByMagezine();
                    break;
                case "c":
                    docManagement.searchByNewspaper();
                    break;
                case "d":
                    exit = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
                    break;
            }
        }
    }

    private static void manageUsers(Scanner scan) {
        System.out.println("Quan ly tai khoan nguoi dung (Chuc nang chua duoc cai dat).");
    }
}
