package br.com.deliver.testepratico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deliver.testepratico.entities.ContasEntity;

@Repository
public interface ContasRepository extends JpaRepository<ContasEntity, Integer>{

}
