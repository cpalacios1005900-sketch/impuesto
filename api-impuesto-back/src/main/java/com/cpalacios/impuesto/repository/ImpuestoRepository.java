package com.cpalacios.impuesto.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpalacios.impuesto.entity.ImpuestoEntity;

@Repository
public interface ImpuestoRepository extends JpaRepository<ImpuestoEntity, Long> {
	



	List<ImpuestoEntity> findByFechaMovimiento(LocalDate fechaMovimiento);
	
}
