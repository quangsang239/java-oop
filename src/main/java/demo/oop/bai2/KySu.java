package demo.oop.bai2;

import java.util.Scanner;

public class KySu extends CanBo {
  private String nganhDT;

  public KySu(String hoTen, String ngaySinh, String gioiTinh, String diaChi, String nganhDT) {
    super(hoTen, ngaySinh, gioiTinh, diaChi);
    this.nganhDT = nganhDT;
  }

  public KySu() {
  }

  public String getNganhDT() {
    return nganhDT;
  }

  public void setNganhDT(String nganhDT) {
    this.nganhDT = nganhDT;
  }

  @Override
  public void setInfo() {
    super.setInfo();
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Nhập Công việc:");
    this.nganhDT = keyboard.nextLine().trim();
  }

  @Override
  public String getInfo() {
    return super.getInfo() + "; Chức vụ: Kỹ sư";
  }
}
