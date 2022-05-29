
package com.pdp.servicepdp.abstratas;

import javax.persistence.Query;
import java.util.List;

abstract public class dao<T> {
    public void create(T objeto){
        Dados.getEntityManager().getTransaction().begin();
        Dados.getEntityManager().persist(objeto);
        Dados.getEntityManager().getTransaction().commit();
    }

    public void update(T objeto){
        Dados.getEntityManager().getTransaction().begin();
        Dados.getEntityManager().merge(objeto);
        Dados.getEntityManager().getTransaction().commit();
    }

    public void delete(T objeto){
        Dados.getEntityManager().getTransaction().begin();
        Dados.getEntityManager().remove(objeto);
        Dados.getEntityManager().getTransaction().commit();
    }

    public T read(Class<T> classToReturn, int id){
        return Dados.getEntityManager().find(classToReturn, id);        
    }

    public List<T> read(String JPQL){
        Query query = Dados.getEntityManager().createQuery(JPQL);
        return query.getResultList();
    }

    public List<T> read(String JPQL,Object... args){
        Query query = Dados.getEntityManager().createQuery(JPQL);
        for(int i=0; i < args.length; i++){
            query.setParameter((i+1), args[i]);
        }
        return query.getResultList();
    }
}
