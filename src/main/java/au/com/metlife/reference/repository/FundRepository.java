package au.com.metlife.reference.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.metlife.reference.entity.Fund;
import au.com.metlife.reference.entity.Industry;

public interface FundRepository extends JpaRepository<Fund, Long> {

	List<Fund> findByName(String name);
	Fund findById(String funcCode);
}
