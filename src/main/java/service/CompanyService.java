package service;

import domain.Company;
import org.springframework.stereotype.Service;
import service.base.BaseService;

import javax.transaction.Transactional;

@Service
@Transactional
public class CompanyService extends BaseService<Company> {
}
