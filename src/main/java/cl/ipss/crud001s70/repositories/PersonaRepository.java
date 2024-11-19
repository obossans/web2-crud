package cl.ipss.crud001s70.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.crud001s70.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
    //Conexion a jpa repository hacia el modelo persona

}
