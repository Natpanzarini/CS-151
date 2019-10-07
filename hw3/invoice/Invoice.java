import java.util.*;
import javax.swing.event.*;

/**
   An invoice for a sale, consisting of line items.
*/
public class Invoice
{
  Hashtable<LineItem, Integer> numItems;
   /**
      Constructs a blank invoice.
   */
   public Invoice()
   {
      items = new ArrayList<>();
      listeners = new ArrayList<>();
      numItems = new Hashtable<>();
   }

  /**
      Adds an item to the invoice.
      @param item the item to add
   */
   public void addItem(LineItem item)
   {
      items.add(item);
      if(numItems.containsKey(item)){
        numItems.put(item,numItems.get(item) + 1);
      }
      else{
        numItems.put(item,1);
      }
      // Notify all observers of the change to the invoice
      ChangeEvent event = new ChangeEvent(this);
      for (ChangeListener listener : listeners)
         listener.stateChanged(event);
   }

   /**
      Adds a change listener to the invoice.
      @param listener the change listener to add
   */
   public void addChangeListener(ChangeListener listener)
   {
      listeners.add(listener);
   }

   /**
      Gets an iterator that iterates through the items.
      @return an iterator for the items
   */
   public Iterator<LineItem> getItems()
   {
      return new
         Iterator<LineItem>()
         {
            public boolean hasNext()
            {
               return current < items.size();
            }

            public LineItem next()
            {
               return items.get(current++);
            }

            public void remove()
            {
               throw new UnsupportedOperationException();
            }

            private int current = 0;
         };
   }

   public String format(InvoiceFormatter formatter)
   {
      String r = formatter.formatHeader();
      Iterator<LineItem> iter = getItems();
      ArrayList<String> printed = new ArrayList<>();

      while(iter.hasNext()){
        LineItem current = iter.next();
        if(!printed.contains(current.toString())){
          printed.add(current.toString());
          r += formatter.formatLineItem(current,numItems.get(current));
        }
        else{
          formatter.formatLineItem(current,numItems.get(current));
        }
      }

      return r + formatter.formatFooter();
   }

   private ArrayList<LineItem> items;
   private ArrayList<ChangeListener> listeners;
}
