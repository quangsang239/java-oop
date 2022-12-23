package demo.oop.bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CanBo {
  private String hoTen;
  private String ngaySinh;
  private String gioiTinh;
  private String diaChi;
  public static List<CanBo> listCanBo = new ArrayList<>();

  public CanBo(String hoTen, String ngaySinh, String gioiTinh, String diaChi) {
    this.hoTen = hoTen;
    this.ngaySinh = ngaySinh;
    this.gioiTinh = gioiTinh;
    this.diaChi = diaChi;
  }

  public CanBo() {
  }

  public String getHoTen() {
    return hoTen;
  }

  public void setHoTen(String hoTen) {
    this.hoTen = hoTen;
  }

  public String getNgaySinh() {
    return ngaySinh;
  }

  public void setNgaySinh(String ngaySinh) {
    this.ngaySinh = ngaySinh;
  }

  public String getDiaChi() {
    return diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  public String getGioiTinh() {
    return gioiTinh;
  }

  public void setGioiTinh(String gioiTinh) {
    this.gioiTinh = gioiTinh;
  }

  public void setInfo() {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Nhập tên:");
    this.hoTen = keyboard.nextLine().trim();
    System.out.println("Nhập năm sinh:");
    this.ngaySinh = keyboard.nextLine().trim();
    System.out.println("Nhập giới tính:");
    this.gioiTinh = keyboard.nextLine().trim();
    System.out.println("Nhập địa chỉ: ");
    this.diaChi = keyboard.nextLine().trim();
  }

  public String getInfo() {
    return "Thông tin công nhân: " + this.getHoTen() + "; Giới tính: " + this.getGioiTinh() + "; Ngày Sinh "
        + this.getNgaySinh() + "; Địa chỉ: " + this.getDiaChi();
  }
}
