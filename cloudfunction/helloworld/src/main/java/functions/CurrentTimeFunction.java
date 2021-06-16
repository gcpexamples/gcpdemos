package functions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class CurrentTimeFunction implements HttpFunction {
  // Simple function to return "current server time "
  @Override
  public void service(HttpRequest request, HttpResponse response)
      throws IOException {
    response.setContentType("text/html; charset=UTF-8");
    BufferedWriter writer = response.getWriter();
    LocalDateTime dateTime=LocalDateTime.now();
    DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss");
    String datetimeText=dateTime.format(format);
    ZoneId systemTimezone=ZoneId.systemDefault();
    String systemTimeZoneText=systemTimezone.getId();
    writer.write("servert time is "+datetimeText +" timezone is "+systemTimeZoneText);
  }
}
