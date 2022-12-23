package demo.oop.bai3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ForeignCustomer extends Customer {
  private String nationality;
  protected static List<ForeignCustomer> listForeignCustomers = new ArrayList<>();

  public ForeignCustomer(String customerId, String fullName, Date invoiceDate, Double amountElectric,
      String nationality) {
    super(customerId, fullName, invoiceDate, amountElectric);
    this.nationality = nationality;
  }

  public ForeignCustomer() {
  }

  @Override
  public void setInfo() {
    super.setInfo();
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Quốc tịch:");
    this.nationality = keyboard.nextLine().trim();
  }

  @Override
  public Double calculateTotalPrice() {
    return this.getAmountElectric() * UNIT_PRICE;
  }

  @Override
  public String getInfo() {
    return super.getInfo() + " Loại khách hàng: Nước ngoài Quốc tịch: " + this.getNationality();
  }

  public static void printInvoice() {
    Calendar cal = Calendar.getInstance();
    for (ForeignCustomer foreignCustomers : listForeignCustomers) {
      cal.setTime(foreignCustomers.getInvoiceDate());
      if (cal.get(Calendar.MONTH) + 1 == 9 && cal.get(Calendar.YEAR) == 2013) {
        System.out.println(foreignCustomers.getInfo());
      }
    }

  }

  public static Double calculateTotalAmountElectric() {
    Double totalAmountElectric = 0d;
    for (ForeignCustomer foreignCustomers : listForeignCustomers) {
      totalAmountElectric += foreignCustomers.getAmountElectric();
    }
    return totalAmountElectric;
  }

  public static Double getAveragePrice() {
    return ((calculateTotalAmountElectric() * UNIT_PRICE) / listForeignCustomers.size());
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public static List<ForeignCustomer> getListForeignCustomers() {
    return listForeignCustomers;
  }

  public static void setListForeignCustomers(List<ForeignCustomer> listForeignCustomers) {
    ForeignCustomer.listForeignCustomers = listForeignCustomers;
  }

}
