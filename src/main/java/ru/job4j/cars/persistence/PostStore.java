package ru.job4j.cars.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class PostStore extends AbstractStore<Post> {

    public PostStore(SessionFactory sf) {
        super(sf);
    }

    @Override
    public Post add(Post post) {
        return this.tx(
                session -> {
                    session.save(post);
                    return post;
                }
        );
    }

    @Override
    public void update(int id, Post post) {
        Session session = sf.openSession();
        session.beginTransaction();
        post.setId(id);
        session.update(post);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Post> findAll() {
        return this.tx(
                session -> session.createQuery("select distinct p from Post p " +
                                "join fetch p.car c " +
                                "join fetch c.brand br " +
                                "join fetch br.models bm " +
                                "join fetch c.model m " +
                                "join fetch c.body b " +
                                "join fetch c.engine e " +
                                "join fetch p.user u ", Post.class)
                        .list()
        );
    }

    @Override
    public Post findById(int id) {
        return this.tx(
                session -> session.createQuery("select distinct p from Post p " +
                                "join fetch p.car c " +
                                "join fetch c.brand br " +
                                "join fetch br.models bm " +
                                "join fetch c.model m " +
                                "join fetch c.body b " +
                                "join fetch c.engine e " +
                                "join fetch p.user u where p.id = :pid", Post.class)
                        .setParameter("pid", id)
                        .uniqueResult()
        );
    }

    @Override
    public void delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Post removablePost = new Post();
        removablePost.setId(id);
        session.delete(removablePost);
        session.getTransaction().commit();
        session.close();
    }

    public List<Post> findNewPosts() {
        return this.tx(
                session -> session.createQuery("select distinct p from Post p " +
                                "join fetch p.car c " +
                                "join fetch c.brand br " +
                                "join fetch br.models bm " +
                                "join fetch c.model m " +
                                "join fetch c.body b " +
                                "join fetch c.engine e " +
                                "join fetch p.user u where p.created >= date_trunc('DAY', current_date)", Post.class)
                        .list()
        );
    }

    public List<Post> findPostsWithBrand(int brandId) {
        return this.tx(
                session -> session.createQuery("select distinct p from Post p " +
                                "join fetch p.car c " +
                                "join fetch c.brand br " +
                                "join fetch br.models bm " +
                                "join fetch c.model m " +
                                "join fetch c.body b " +
                                "join fetch c.engine e " +
                                "join fetch p.user u where c.brand.id = :brandId", Post.class)
                        .setParameter("brandId", brandId)
                        .list()
        );
    }
}