package com.sau.library.repositories;

import com.sau.library.models.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,Integer> {
}
