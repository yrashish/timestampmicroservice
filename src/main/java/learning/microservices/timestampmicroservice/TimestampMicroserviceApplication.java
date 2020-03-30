package learning.microservices.timestampmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
@RestController
public class TimestampMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimestampMicroserviceApplication.class, args);
	}

	@RequestMapping(value = "/api/timestamp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private Response hello(@RequestParam String date) throws ParseException {
		String currentDate = LocalDate.now().toString();
		SimpleDateFormat myFormat = new SimpleDateFormat("EEE, d MMM yyyy");
		SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
		String reformattedStr = myFormat.format(fromUser.parse(date));
		Date date1 = myFormat.parse(reformattedStr);
		long time = date1.getTime();
		Response response = new Response(time, date1);
		return response;
		//return date!=null? Collections.singleton(localDate) : Collections.singleton(LocalDate.now());
	}
}
