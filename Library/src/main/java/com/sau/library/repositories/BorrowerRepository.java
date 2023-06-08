package com.sau.library.repositories;

import com.sau.library.models.Borrower;
import org.springframework.data.repository.CrudRepository;

public interface BorrowerRepository extends CrudRepository<Borrower, Integer> {
}
