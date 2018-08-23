package com.anuradha.demo.Repository;

import com.anuradha.demo.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, Integer> {
}
