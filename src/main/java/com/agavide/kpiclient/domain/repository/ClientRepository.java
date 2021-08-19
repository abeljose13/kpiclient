package com.agavide.kpiclient.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agavide.kpiclient.domain.model.Client;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
