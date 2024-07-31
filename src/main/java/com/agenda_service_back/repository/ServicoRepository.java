package com.agenda_service_back.repository;

import com.agenda_service_back.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    @Query("SELECT s FROM Servico s WHERE s.nome = :servicoNome")
    List<Servico> findByServicoNome(@Param("servicoNome") String servicoNome);


}
