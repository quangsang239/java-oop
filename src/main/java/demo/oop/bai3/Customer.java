package demo.oop.bai3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Customer {
  private String customerId;
  private String fullName;
  private Date invoiceDate;
  private Double amountElectric;
  protected static final Double UNIT_PRICE = 2536d;

  protected Customer(String customerId, String fullName, Date invoiceDate, Double amountElectric) {
    this.customerId = customerId;
    this.fullName = fullName;
    this.invoiceDate = invoiceDate;
    this.amountElectric = amountElectric;
  }

  protected Customer() {
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Date getInvoiceDate() {
    return invoiceDate;
  }

  public void setInvoiceDate(Date invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  public static Double getUnitPrice() {
    return UNIT_PRICE;
  }

  public abstract Double calculateTotalPrice();

  public String getInfo() {
    return "Mã cá khách hàng: " + this.customerId + " Tên khách hàng: " + this.fullName + " Lượng điện tiêu thụ: "
        + this.amountElectric.toString();
  }

  public void setInfo() {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Nhập id khách hàng:");
    this.customerId = keyboard.nextLine().trim();
    System.out.println("Nhập tên:");
    this.fullName = keyboard.nextLine().trim();
    Boolean getInfo = true;
    while (Boolean.TRUE.equals(getInfo)) {
      try {
        System.out.println("Ngày xuất hoá đơn:");
        Date newDate;
        newDate = new SimpleDateFormat("dd/MM/yyyy").parse(keyboard.nextLine().trim());
        this.invoiceDate = newDate;
        System.out.println(newDate);
        getInfo = false;
      } catch (ParseException e) {
        System.out.println("Không phải định dạng ngày!");
        getInfo = true;
      }
    }
    getInfo = true;
    while (Boolean.TRUE.equals(getInfo)) {
      try {
        System.out.println("Lượng điện tiêu thụ: ");
        this.amountElectric = Double.parseDouble(keyboard.nextLine().trim());
        getInfo = false;
      } catch (Exception e) {
        System.out.println("Không phải định dạng là số!");
        getInfo = true;
      }
    }
    System.out.println("Nhập thông tin khách hàng thành công!");
  }

  public Double getAmountElectric() {
    return amountElectric;
  }

  public void setAmountElectric(Double amountElectric) {
    this.amountElectric = amountElectric;
  }

}
