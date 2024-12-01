/*package quan_ly_sach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main2 extends JFrame {
    private DocumentManagement documentManagement;
    
    public Main2() 
    {
        documentManagement = new DocumentManagement();
        
        setTitle("Quản lý Tài liệu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the main panel with a grid layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        // Create buttons
        JButton addButton = new JButton("Thêm tài liệu");
        JButton removeButton = new JButton("Xóa tài liệu");
        JButton displayButton = new JButton("Hiển thị thông tin tài liệu");
        JButton searchButton = new JButton("Hiển thị tài liệu theo loại");
        JButton exitButton = new JButton("Thoát");

        // Add buttons to panel
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(displayButton);
        panel.add(searchButton);
        panel.add(exitButton);

        // Add action listeners to buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDocument();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeDocument();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayDocuments();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchDocuments();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(panel);
    }

    private void addDocument() {
        String[] options = {"Sách", "Tạp chí", "Báo"};
        int choice = JOptionPane.showOptionDialog(this, "Chọn loại tài liệu muốn thêm:", "Thêm tài liệu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            // Thêm sách
            JTextField idField = new JTextField();
            JTextField nxbField = new JTextField();
            JTextField releaseNumField = new JTextField();
            JTextField authorField = new JTextField();
            JTextField numPageField = new JTextField();

            Object[] message = {
                    "Mã tài liệu:", idField,
                    "Nhà xuất bản:", nxbField,
                    "Số lượng phát hành:", releaseNumField,
                    "Tác giả:", authorField,
                    "Số trang:", numPageField,
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Thêm sách", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String id = idField.getText();
                String nameNXB = nxbField.getText();
                int releaseNum = Integer.parseInt(releaseNumField.getText());
                String author = authorField.getText();
                int numPage = Integer.parseInt(numPageField.getText());
                Document book = new Book(id, nameNXB, releaseNum, author, numPage);
                documentManagement.addDocument(book);
            }
        } else if (choice == 1) {
            // Thêm tạp chí
            JTextField idField = new JTextField();
            JTextField nxbField = new JTextField();
            JTextField releaseNumField = new JTextField();
            JTextField idReleaseField = new JTextField();
            JTextField monthReleaseField = new JTextField();

            Object[] message = {
                    "Mã tài liệu:", idField,
                    "Nhà xuất bản:", nxbField,
                    "Số lượng phát hành:", releaseNumField,
                    "Mã phát hành:", idReleaseField,
                    "Tháng phát hành:", monthReleaseField,
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Thêm tạp chí", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String id = idField.getText();
                String nameNXB = nxbField.getText();
                int releaseNum = Integer.parseInt(releaseNumField.getText());
                int idRelease = Integer.parseInt(idReleaseField.getText());
                int monthRelease = Integer.parseInt(monthReleaseField.getText());
                Document magezine = new Magezine(id, nameNXB, releaseNum, idRelease, monthRelease);
                documentManagement.addDocument(magezine);
            }
        } else if (choice == 2) {
            // Thêm báo
            JTextField idField = new JTextField();
            JTextField nxbField = new JTextField();
            JTextField releaseNumField = new JTextField();
            JTextField dayReleaseField = new JTextField();

            Object[] message = {
                    "Mã tài liệu:", idField,
                    "Nhà xuất bản:", nxbField,
                    "Số lượng phát hành:", releaseNumField,
                    "Ngày phát hành:", dayReleaseField,
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Thêm báo", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String id = idField.getText();
                String nameNXB = nxbField.getText();
                int releaseNum = Integer.parseInt(releaseNumField.getText());
                int dayRelease = Integer.parseInt(dayReleaseField.getText());
                Document newspaper = new Newspaper(id, nameNXB, releaseNum, dayRelease);
                documentManagement.addDocument(newspaper);
            }
        }
    }

    private void removeDocument() {
        String id = JOptionPane.showInputDialog(this, "Nhập mã tài liệu muốn xóa:");
        if (id != null && !id.trim().isEmpty()) {
            if (documentManagement.removeDocument(id)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
        }
    }

    private void displayDocuments() {
        JTextArea textArea = new JTextArea(20, 30);
        textArea.setEditable(false);
        for (Document doc : documentManagement.getDocuments()) {
            textArea.append(doc.getId() + ": ");
            doc.displayInfo(textArea);
            textArea.append("\n");
        }
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Danh sách tài liệu", JOptionPane.INFORMATION_MESSAGE);
    }

    private void searchDocuments() {
        String[] options = {"Sách", "Tạp chí", "Báo"};
        int choice = JOptionPane.showOptionDialog(this, "Chọn loại tài liệu muốn hiển thị:", "Hiển thị tài liệu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        JTextArea textArea = new JTextArea(20, 30);
        textArea.setEditable(false);

        if (choice == 0) {
            for (Document doc : documentManagement.getDocuments()) {
                if (doc instanceof Book) {
                    doc.displayInfo(textArea);
                    textArea.append("\n");
                }
            }
        } else if (choice == 1) {
            for (Document doc : documentManagement.getDocuments()) {
                if (doc instanceof Magezine) {
                    doc.displayInfo(textArea);
                    textArea.append("\n");
                }
            }
        } else if (choice == 2) {
            for (Document doc : documentManagement.getDocuments()) {
                if (doc instanceof Newspaper) {
                    doc.displayInfo(textArea);
                    textArea.append("\n");
                }
            }
        }

        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() 
            {
                new Main2().setVisible(true);
            }
        });
    }
}
*/
