package com.p23studios.basicspringangularapi.repository;

import com.p23studios.basicspringangularapi.enums.Roles;
import com.p23studios.basicspringangularapi.model.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Data Access Abstraction
public interface MemberRepository extends JpaRepository<MemberModel, Long> {
     List<MemberModel> findByRole(Roles role);
}
