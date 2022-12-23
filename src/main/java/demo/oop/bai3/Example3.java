package demo.oop.bai3;

import java.util.Scanner;

public class Example3 {
  public static void main(String[] args) {
    Boolean exit = false;
    Scanner keyboard = new Scanner(System.in);
    while (Boolean.FALSE.equals(exit)) {
      System.out.println("Chọn phương thức:");
      System.out.println("1: Nhập thông tin hoá đơn khách hàng!");
      System.out.println("2: Tính tổng lượng điện tiêu thụ cho từng loại khách hàng!");
      System.out.println("3: Tính trung bình tiền của khách hàng nước ngoài!");
      System.out.println("4: Xuất ra hoá đơn tháng 9 2013 của 2 loại khách hàng!");
      System.out.println("q: Thoát!");
      String input = keyboard.nextLine();
      if ("q".equals(input)) {
        System.out.println("Thoát chương trình");
        exit = true;
        keyboard.close();
      } else if ("1".equals(input)) {
        Boolean addNewCustomer = true;
        while (Boolean.TRUE.equals(addNewCustomer)) {
          System.out.println("Chọn loại khách hàng");
          System.out.println("1: Khách hàng trong nước");
          System.out.println("2: Khách hàng nước ngoài");
          System.out.println("q: Thoát!");
          String keyAddCustomer = keyboard.nextLine();
          if ("q".equals(keyAddCustomer)) {
            addNewCustomer = false;
            System.out.println("Thoát chức năng!");
          } else if ("1".equals(keyAddCustomer)) {
            DomesticCustomers domesticCustomers = new DomesticCustomers();
            domesticCustomers.setInfo();
            DomesticCustomers.listDomesticCustomers.add(domesticCustomers);
            System.out.println("Thêm khánh hàng thành công!");
          } else if ("2".equals(keyAddCustomer)) {
            ForeignCustomer foreignCustomer = new ForeignCustomer();
            foreignCustomer.setInfo();
            ForeignCustomer.listForeignCustomers.add(foreignCustomer);
            System.out.println("Thêm khách hàng thành công");
          } else {
            System.out.println("Vui lòng chọn đúng chức năng");
          }
        }
      } else if ("2".equals(input)) {
        System.out.println("Tổng lượng điện tiêu thụ của khách hàng trong nước là: "
            + DomesticCustomers.calculateTotalAmountElectric());
        System.out.println("Tổng lượng điện tiêu thụ của khách hàng nước ngoài là: "
            + ForeignCustomer.calculateTotalAmountElectric());
      } else if ("3".equals(input)) {
        System.out.println("Trung bình tiền điện của khách hàng nước ngoài là: " + ForeignCustomer.getAveragePrice());
      } else if ("4".equals(input)) {
        System.out.println(
            "Hoá đơn tháng 9 2013 của khách hàng trong nước là: ");
        DomesticCustomers.printInvoice();
        System.out.println("Hoá đơn tháng 9 2013 của khách hàng nước ngoài là: ");
        ForeignCustomer.printInvoice();
      }
    }

  }
}
