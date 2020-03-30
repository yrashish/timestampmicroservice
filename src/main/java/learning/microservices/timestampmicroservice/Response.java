package learning.microservices.timestampmicroservice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Response {

    private Long unix;
    private Date utc;
}
