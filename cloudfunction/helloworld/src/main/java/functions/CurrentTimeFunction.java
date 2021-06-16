package functions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTimeFunction implements HttpFunction {
  // Simple function to return "current server time "
  @Override
  public void service(HttpRequest request, HttpResponse response)
      throws IOException {
    BufferedWriter writer = response.getWriter();
    LocalDateTime dateTime=LocalDateTime.now();
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yy hh:mm:ss");
    String dateTimeText=dateTime.format(formatter);
    writer.write("Current time is "+dateTimeText);
  }
}
