package pm.mbo.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/foo")
public class FootController {

	@RequestMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public ResponseEntity<String> get(@PathVariable("id") final String id,
	                                  final HttpServletRequest req,
	                                  final HttpServletResponse res) {
		if (req.getHeader("Test") != null) {
			log.debug("got header test");
			res.addHeader("Test", req.getHeader("Test"));
		}
		return new ResponseEntity<String>("ok: " + id, HttpStatus.OK);
	}

}
