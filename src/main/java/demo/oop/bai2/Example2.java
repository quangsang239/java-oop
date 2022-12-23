package demo.oop.bai2;

import java.util.Scanner;

public class Example2 {

  public static void findByName(String name) {
    Boolean foundUser = false;
    for (CanBo canBo : CanBo.listCanBo) {
      if (canBo.getHoTen().toLowerCase().contains(name.trim().toLowerCase())) {
        System.out.println(canBo.getInfo());
        foundUser = true;
      }
      if (Boolean.FALSE.equals(foundUser)) {
        System.out.println("Không tìm thấy thông tin!");
      }
    }
  }

  public static void showAllCanBo() {
    System.out.println("Thông tin tất cả công nhân:");
    for (CanBo canBo : CanBo.listCanBo) {
      System.out.println(canBo.getInfo());
    }
  }

  public static void main(String[] args) {
    Boolean exit = false;
    Scanner keyboard = new Scanner(System.in);
    while (Boolean.FALSE.equals(exit)) {
      System.out.println("Chọn phương thức:");
      System.out.println("1: Nhập thông tin nhâp viên mới!");
      System.out.println("2: Tìm kiếm theo họ tên!");
      System.out.println("3: Hiển thị danh sách các cán bộ!");
      System.out.println("q: Thoát!");
      String input = keyboard.nextLine();
      if ("q".equals(input)) {
        System.out.println("Dừng chương trình!");
        exit = true;
        keyboard.close();
      } else if ("1".equals(input)) {
        Boolean themCanBo = true;
        while (Boolean.TRUE.equals(themCanBo)) {
          System.out.println("Chọn chức vụ cán bộ!");
          System.out.println("1: Nhân viên!");
          System.out.println("2: Công nhân!");
          System.out.println("3: Kỹ sư!");
          System.out.println("q: Thoát");
          String addStaff = keyboard.nextLine();
          if ("q".equals(addStaff)) {
            themCanBo = false;
          } else if ("1".equals(addStaff)) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setInfo();
            CanBo.listCanBo.add(nhanVien);
            System.out.println("Thêm nhân viên mới thành công!");
          } else if ("2".equals(addStaff)) {
            CongNhan congNhan = new CongNhan();
            congNhan.setInfo();
            CanBo.listCanBo.add(congNhan);
            System.out.println("Thêm công nhân thành công!");
          } else if ("3".equals(addStaff)) {
            KySu kySu = new KySu();
            kySu.setInfo();
            CanBo.listCanBo.add(kySu);
            System.out.println("Thêm kỹ sư thành công!");
          }
        }
      } else if ("2".equals(input)) {
        System.out.println("Nhập tên công nhân cần tìm kiếm!");
        String name = keyboard.nextLine();
        Example2.findByName(name);
      } else if ("3".equals(input)) {
        Example2.showAllCanBo();
      } else {
        System.out.println("Vui lòng chọn đúng chức năng!");
      }
    }
  }
}
