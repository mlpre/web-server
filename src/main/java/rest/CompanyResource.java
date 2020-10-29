package rest;

import domain.Company;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.base.BaseResource;

@RestController
@RequestMapping("/api/company")
public class CompanyResource extends BaseResource<Company> {

}
