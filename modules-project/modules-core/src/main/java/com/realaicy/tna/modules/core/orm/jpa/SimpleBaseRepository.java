package com.realaicy.tna.modules.core.orm.jpa;

import com.realaicy.tna.modules.core.orm.jpa.search.Searchable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by Realaicy on 2015/5/14.
 *
 * @param <T>  the type parameter
 * @param <ID> the type parameter
 */
public class SimpleBaseRepository<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    /**
     * FOR TESTONLY
     */
    private static final int DUMMYCOUNT = 100;

    /**
     * xxx
     */
    private final EntityManager entityManager;


    /**
     * Instantiates a new Simple base repository.
     *
     * @param domainClass   the domain class
     * @param entityManager the entity manager
     */
// There are two constructors to choose from, either can be used.
    public SimpleBaseRepository(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
// This is the recommended method for accessing inherited class dependencies.
        this.entityManager = entityManager;
    }

    public SimpleBaseRepository(JpaEntityInformation entityInformation,
                            EntityManager entityManager) {
        super(entityInformation, entityManager);

        // Keep the EntityManager around to used from the newly introduced methods.
        this.entityManager = entityManager;
    }


    @Override
    public void delete(ID[] ids) {

    }

    @Override
    public Page<T> findAll(Searchable searchable) {
        return null;
    }

    @Override
    public long count(Searchable searchable) {
        return 0;
    }

    @Override
    public int count(String temp) {
        return DUMMYCOUNT;
    }
}
