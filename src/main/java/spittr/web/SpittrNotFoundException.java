package spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by root on 18.10.16.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Spittle not found!")
public class SpittrNotFoundException extends RuntimeException {
}
