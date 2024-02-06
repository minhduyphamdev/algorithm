import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Booking {
  private LocalDateTime startTime;
  private LocalDateTime endTime;

  public Booking(LocalDateTime startTime, LocalDateTime endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }
}



public class OverlapTime {

  public static int getRandomInteger(int min, int max) {
    return (int)(Math.random() * (max-min)) + min;
  }
  public static boolean isOverlap(LocalDateTime startTime1, LocalDateTime endTime1, LocalDateTime startTime2, LocalDateTime endTime2) {
    return (startTime1.isBefore(endTime2) && endTime1.isAfter(startTime2)) || (startTime2.isBefore(endTime1) && endTime2.isAfter(startTime1));
  }

  public static void main(String[] args) {
    List<Booking> bookings = new ArrayList<Booking>();

      bookings.add(new Booking(LocalDateTime.of(2023, 1, 1, 8, 0), LocalDateTime.of(2023, 1, 1, 10, 0)));
      bookings.add(new Booking(LocalDateTime.of(2023, 1, 1, 9, 30), LocalDateTime.of(2023, 1, 1, 11, 0)));
      bookings.add(new Booking(LocalDateTime.of(2023, 1, 1, 10, 30), LocalDateTime.of(2023, 1, 1, 14, 0)));
    
    for(int i=0;i<bookings.size();i++) {
      for (int j = i + 1; j < bookings.size(); j++) {
      Booking booking1 = bookings.get(i);
      Booking booking2 = bookings.get(j);
      boolean isOverlap = isOverlap(booking1.getStartTime(), booking1.getEndTime(),
                                       booking2.getStartTime(), booking2.getEndTime());
      System.out.println("Booking " + (i + 1) + " and Booking " + (j + 1) + ": " + isOverlap);

      }
    }
  }
}
