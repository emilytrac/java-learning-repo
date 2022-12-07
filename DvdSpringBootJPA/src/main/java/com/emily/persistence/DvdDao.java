package com.emily.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emily.entity.DVD;

@Repository
public interface DvdDao extends JpaRepository<DVD, Integer> {

	@Query("from DVD where title=:title")
	DVD searchDVDByName(@Param("title") String title);
	
	@Modifying
	@Transactional
	@Query("delete from DVD where title=:title")
	int deleteByName(@Param("title") String title);
	
}
