public class HTMLFormatter implements InvoiceFormatter{

  public String formatHeader()
  {
     total = 0;
     String invoiceHeader = new String("<b><h1 style = 'color: red'; align = 'center' >"+ "INVOICE\n\n" + "</h1></b><br><br>");
     return invoiceHeader;
  }

  public String formatLineItem(LineItem item, int count)
  {
     total += item.getPrice();
     return (String.format("<b>- %s: $%.2f    x%d   \n<br>",item.toString(),item.getPrice(),count));
  }

  public String formatFooter()
  {
    return (String.format("<b><h1 style = 'color: green'; align = 'center' >" + "\n\nTOTAL DUE: $%.2f\n", total));
  }

  private double total;
  private double itemsTotal;
}
