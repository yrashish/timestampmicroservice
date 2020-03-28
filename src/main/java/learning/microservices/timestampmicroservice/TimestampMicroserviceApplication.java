package learning.microservices.timestampmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
@RestController
public class TimestampMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimestampMicroserviceApplication.class, args);
	}

	@RequestMapping(value ="/api/timestamp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private LocalDate hello(@RequestParam Optional<String> date){
		String currentDate = LocalDate.now().toString();
		LocalDate localDate = LocalDate.parse(date.orElseGet(()->currentDate));
		return  localDate;
		//return date!=null? Collections.singleton(localDate) : Collections.singleton(LocalDate.now());
	}
}
