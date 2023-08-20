package com.counter.counter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<NumberEntity, Long> {
}
