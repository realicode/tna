package com.realaicy.tna.modules.core.orm.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by Realaicy on 2015/5/14.
 *
 * @param <R> the type parameter
 * @param <T> the type parameter
 * @param <I> the type parameter
 */
public class RealRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends
        Serializable>
        extends JpaRepositoryFactoryBean<R, T, I> {

    /**
     * Instantiates a new Real repository factory bean.
     */
    public RealRepositoryFactoryBean() {
    }

    /**
     * XXX.
     *
     * @param entityManager xxx
     * @return xxx
     */
    protected RepositoryFactorySupport createRepositoryFactory(
            EntityManager entityManager) {
        return new RealRepositoryFactory(entityManager);
    }

    /**
     * The type Real repository factory.
     *
     * @param <T> the type parameter
     * @param <I> the type parameter
     */
    class RealRepositoryFactory<T, I extends Serializable> extends
            JpaRepositoryFactory {
        /**
         * XXX.
         */
        private EntityManager entityManager;

        /**
         * Instantiates a new Real repository factory.
         *
         * @param entityManager the entity manager
         */
        RealRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
            this.entityManager = entityManager;
        }

        /**
         * {@inheritDoc}
         */
        protected Object getTargetRepository(RepositoryMetadata metadata) {
            return new SimpleBaseRepository<>((Class<T>) metadata.getDomainType(),
                    entityManager);
        }

        /**
         * {@inheritDoc}
         */
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
// The RepositoryMetadata can be safely ignored, it is used by the JpaRepositoryFactory
//to check for QueryDslJpaRepository's which is out of scope.
            return SimpleBaseRepository.class;
        }
    }
}