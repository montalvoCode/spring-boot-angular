package com.project.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.LegalCustomerService;

@RestController
@RequestMapping("/legalCustomer")
public class LegalCustomerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LegalCustomerService legalCustomerService;

//	@GetMapping(value = "/list-legal-customer", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<LegalCustomer>> listLegalCustomer() {
//		logger.info("> Starting list legalCustomer");
//
//		List<LegalCustomer> list = legalCustomerService.findAll();
//
//		if (list == null || list.isEmpty()) {
//			return new ResponseEntity<List<LegalCustomer>>(list, HttpStatus.BAD_REQUEST);
//		}
//
//		return new ResponseEntity<List<LegalCustomer>>(list, HttpStatus.OK);
//	}
//
//	@PostMapping(value = "/create-legal-customer", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<LegalCustomer> createLegalCustomer(@RequestBody LegalCustomer legalCustomer,
//			BindingResult bindingResult, UriComponentsBuilder ucBuilder) {
//		logger.info("> Starting create legal-customer");
//		BindingErrorsResponse errors = new BindingErrorsResponse();
//		HttpHeaders headers = new HttpHeaders();
//
//		if (bindingResult.hasErrors() || legalCustomer == null) {
//			errors.addAllErrors(bindingResult);
//			headers.add("errors", errors.toJSON());
//			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
//		}
//
//		legalCustomerService.create(legalCustomer);
//		return new ResponseEntity<>(headers, HttpStatus.CREATED);
//	}
}
