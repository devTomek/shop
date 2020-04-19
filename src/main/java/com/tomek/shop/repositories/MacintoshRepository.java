package com.tomek.shop.repositories;

import com.tomek.shop.models.Macintosh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MacintoshRepository extends JpaRepository<Macintosh, Long> {
}
