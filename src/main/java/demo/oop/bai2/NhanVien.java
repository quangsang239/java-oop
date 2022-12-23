package demo.oop.bai2;

import java.util.Scanner;

public class NhanVien extends CanBo {
  private String congViec;

  public NhanVien(String hoTen, String ngaySinh, String gioiTinh, String diaChi, String congViec) {
    super(hoTen, ngaySinh, gioiTinh, diaChi);
    this.congViec = congViec;
  }

  public NhanVien() {
  }

  public String getCongViec() {
    return congViec;
  }

  public void setCongViec(String congViec) {
    this.congViec = congViec;
  }

  @Override
  public void setInfo() {
    super.setInfo();
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Nhập Công việc:");
    this.congViec = keyboard.nextLine().trim();
  }

  @Override
  public String getInfo() {
    return super.getInfo() + "; Chức vụ: Nhân viên";
  }
}
