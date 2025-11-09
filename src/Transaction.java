package src;

import shared.ColorStyle;
import shared.Helper;

public class Transaction {
    private String type;
    private String date;
    private double amount;
    private double balanceAfter;

    public Transaction(String type, String date, double amount, double balanceAfter) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    @Override
    public String toString() {
        String amountStr = type.toLowerCase().equals("withdrawal") ||
                type.toLowerCase().equals("check") ||
                type.toLowerCase().equals("svc charge")
                        ? String.format(ColorStyle.BRIGHT_RED + "CR %10s" +
                                ColorStyle.RESET_FORMATTING,
                                Helper.formatCurrency(getAmount(), 10))
                        : String.format(ColorStyle.BRIGHT_CYAN + "DR %10s" +
                                ColorStyle.RESET_FORMATTING,
                                Helper.formatCurrency(getAmount(), 10));

        String balanceStr = String.format("$%,13.2f", balanceAfter);

        return String.format(" %-14s %-21s %8s %3s %8s",
                date,
                type,
                amountStr,
                "",
                balanceStr);
    }
}