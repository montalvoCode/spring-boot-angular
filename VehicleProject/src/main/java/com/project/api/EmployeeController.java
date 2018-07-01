package com.project.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeService employeeService;

//	@GetMapping(value = "/list-employees", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Employees>> listEmployee() {
//		logger.info("> Stating list employees");
//
//		List<Employees> list = employeeService.findAll();
//
//		if (list == null || list.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//
//		return new ResponseEntity<List<Employees>>(list, HttpStatus.OK);
//	}
//
//	@PostMapping(value = "/create-employees", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Employees> createEMployee(@RequestBody Employees employees, BindingResult bindingResult,
//                                                    UriComponentsBuilder ucBuilder) {
//
//		logger.info("> Stating create Employees", employees);
//		BindingErrorsResponse errors = new BindingErrorsResponse();
//		HttpHeaders headers = new HttpHeaders();
//
//		if (bindingResult.hasErrors() || employees == null) {
//			errors.addAllErrors(bindingResult);
//			headers.add("errors", errors.toJSON());
//			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
//		}
//
//		employeeService.create(employees);
//		return new ResponseEntity<>(headers, HttpStatus.OK);
//	}
}
