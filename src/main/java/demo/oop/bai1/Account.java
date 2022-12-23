package demo.oop.bai1;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
  private Long accountNumber;
  private String accountName;
  private Double accountBalance;

  public static final Float INTEREST_RATE = 0.035f;

  Account() {
  }

  Account(Long accountNumber, String accountName) {
    this.accountName = accountName;
    this.accountNumber = accountNumber;
    this.accountBalance = 50d;
  }

  Account(Long accountNumber, String accountName, Double accountBalance) {
    this.accountBalance = accountBalance;
    this.accountName = accountName;
    this.accountNumber = accountNumber;
  }

  public void setAccountBalance(Double accountBalance) {
    this.accountBalance = accountBalance;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public void setAccountNumber(Long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public Double getAccountBalance() {
    return accountBalance;
  }

  public String getAccountName() {
    return accountName;
  }

  public Long getAccountNumber() {
    return accountNumber;
  }

  public void rechargeMoney(Double amountMoney) {
    this.accountBalance += amountMoney;
  }

  public void withdrawMoney(Double amountMoney) {
    this.accountBalance -= (amountMoney + INTEREST_RATE * amountMoney);
  }

  public void transferMoney(Account account, Double amountMoney) {
    account.accountBalance += amountMoney;
    this.accountBalance -= (amountMoney + amountMoney * INTEREST_RATE);
  }

  @Override
  public String toString() {
    Locale localVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localVN);
    return "Tên người dùng: " + accountName + " Số tài khoản: " + accountNumber + " Số dư: "
        + currencyVN.format(accountBalance);
  }
}
