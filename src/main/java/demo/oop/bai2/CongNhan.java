package demo.oop.bai2;

import java.util.Scanner;

public class CongNhan extends CanBo {
  private String bac;

  public CongNhan(String hoTen, String ngaySinh, String gioiTinh, String diaChi, String bac) {
    super(hoTen, ngaySinh, gioiTinh, diaChi);
    this.bac = bac;
  }

  public CongNhan() {
  }

  public String getBac() {
    return bac;
  }

  public void setBac(String bac) {
    this.bac = bac;
  }

  @Override
  public String getInfo() {
    return super.getInfo() + "; Chức vụ: Công nhân";
  }

  @Override
  public void setInfo() {
    super.setInfo();
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Nhập bậc:");
    this.bac = keyboard.nextLine().trim();
  }
}
