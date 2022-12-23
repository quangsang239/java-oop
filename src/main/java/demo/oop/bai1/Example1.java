package demo.oop.bai1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Example1 {
  public static void main(String[] args) {
    Map<Long, Account> allAccount = new HashMap<>();
    Account dtri = new Account((long) 12345, "Đức Trí 12", 4000000d);
    Account qsang = new Account((long) 12346, "Quang Sang 239", 3000000d);
    allAccount.put(dtri.getAccountNumber(), dtri);
    allAccount.put(qsang.getAccountNumber(), qsang);
    Boolean exit = false;
    Scanner keyboard = new Scanner(System.in);
    while (Boolean.FALSE.equals(exit)) {
      System.out.println("Bạn đang đăng nhập với tài khoản: " + qsang.toString());
      System.out.println("Chọn phương thức:");
      System.out.println("1: Nạp tiền!");
      System.out.println("2: Rút tiền!");
      System.out.println("3: Chuyển khoản!");
      System.out.println("q: Thoát!");
      String input = keyboard.nextLine();
      if ("q".equals(input)) {
        System.out.println("Thoát chương trình");
        exit = true;
        keyboard.close();
      } else if ("1".equals(input)) {
        Boolean rechargeMoney = true;
        while (rechargeMoney) {
          System.out.println("Nhập số tiền nạp: ");
          String amountMoneyString = keyboard.nextLine();
          try {
            Double amountMoney = Double.parseDouble(amountMoneyString);
            if (amountMoney > 0) {
              qsang.rechargeMoney(amountMoney);
              System.out.println("Nạp tiền thành công!");
              rechargeMoney = false;
            } else {
              System.out.println("Vui lòng nhập số tiền > 0");
            }
          } catch (Exception e) {
            System.out.println("Vui lòng nhập số!");
          }
        }
      } else if ("2".equals(input)) {
        Boolean withdrawMoney = true;
        while (Boolean.TRUE.equals(withdrawMoney)) {
          System.out.println("Vui lòng nhập số tiền rút");
          String amountMoneyString = keyboard.nextLine();
          try {
            Double amountMoney = Double.parseDouble(amountMoneyString);
            if (amountMoney >= 0) {
              if ((amountMoney + amountMoney * Account.INTEREST_RATE) < qsang.getAccountBalance()) {
                qsang.withdrawMoney(amountMoney);
                System.out.println("Rút tiền thành công!");
                withdrawMoney = false;
              } else {
                System.out.println("Số tiền trong tài khoản không đủ!");
              }
            } else {
              System.out.println("Vui lòng nhập số tiền >= 0!");
            }
          } catch (Exception e) {
            System.out.println("Vui lòng nhập số!");
          }
        }
      } else if ("3".equals(input)) {
        Boolean transfer = true;
        while (transfer) {
          System.out.println("Số tiền sẽ được chuyển qua tài khoản: " + dtri.toString());
          System.out.println("Vui lòng nhập số tiền cần chuyển");
          String amountMoneyString = keyboard.nextLine();
          try {
            Double amountMoney = Double.parseDouble(amountMoneyString);
            if (amountMoney > 0) {
              if ((amountMoney + amountMoney * Account.INTEREST_RATE) < qsang.getAccountBalance()) {
                qsang.transferMoney(dtri, amountMoney);
                System.out.println("Chuyển tiền thành công");
                System.out.println(dtri.toString());
                transfer = false;
              } else {
                System.out.println("Số tiền trong tài khoản không đủ!");
              }
            } else {
              System.out.println("Vui lòng nhập số tiền > 0");
            }
          } catch (Exception e) {
            System.out.println("Vui lòng nhập số!");
          }
        }
      } else {
        System.out.println("Vui lòng chọn số mặc định!");
      }
    }
  }
}
