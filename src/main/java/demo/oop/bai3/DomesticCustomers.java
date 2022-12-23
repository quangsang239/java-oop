package demo.oop.bai3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DomesticCustomers extends Customer {
  private static final Double QUOTA = 300d;
  protected static List<DomesticCustomers> listDomesticCustomers = new ArrayList<>();

  public DomesticCustomers() {
  }

  public DomesticCustomers(String customerId, String fullName, Date invoiceDate, Double amountElectric) {
    super(customerId, fullName, invoiceDate, amountElectric);
  }

  @Override
  public Double calculateTotalPrice() {
    if (this.getAmountElectric() <= QUOTA) {
      return this.getAmountElectric() * Customer.UNIT_PRICE;
    } else {
      return ((UNIT_PRICE * this.getAmountElectric()) + (this.getAmountElectric() - 300) * 2.5 * UNIT_PRICE);
    }
  }

  @Override
  public String getInfo() {
    return super.getInfo() + " Loại khách hàng: Trong nước";
  }

  public static void printInvoice() {
    Calendar cal = Calendar.getInstance();
    for (DomesticCustomers domesticCustomers : listDomesticCustomers) {
      cal.setTime(domesticCustomers.getInvoiceDate());

      System.out.println(cal.get(Calendar.MONTH));
      if (cal.get(Calendar.MONTH) + 1 == 9 && cal.get(Calendar.YEAR) == 2013) {
        System.out.println(domesticCustomers.getInfo());
      }
    }
  }

  public static Double calculateTotalAmountElectric() {
    Double totalAmountElectric = 0d;
    for (DomesticCustomers domesticCustomers : listDomesticCustomers) {
      totalAmountElectric += domesticCustomers.getAmountElectric();
    }
    return totalAmountElectric;
  }

  public static Double getQuota() {
    return QUOTA;
  }

  public static List<DomesticCustomers> getListDomesticCustomers() {
    return listDomesticCustomers;
  }

  public static void setListDomesticCustomers(List<DomesticCustomers> listDomesticCustomers) {
    DomesticCustomers.listDomesticCustomers = listDomesticCustomers;
  }

}
