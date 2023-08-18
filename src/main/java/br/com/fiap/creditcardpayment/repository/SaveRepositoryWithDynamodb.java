package br.com.fiap.creditcardpayment.repository;

import br.com.fiap.creditcardpayment.repository.orm.SaleOrm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveRepositoryWithDynamodb extends CrudRepository<SaleOrm, String> {
}
