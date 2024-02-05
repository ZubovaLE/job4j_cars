package ru.job4j.cars.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
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
                session -> session.createQuery("select distinct i from Post i inner join fetch i.car c")
                        .list()
        );
    }

    @Override
    public Post findById(int id) {
        return this.tx(
                session -> session.createQuery("select distinct i from Post i inner join fetch i.car c " +
                                "where i.id = :iid", Post.class)
                        .setParameter("iid", id)
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
                        "join fetch p.user u " +
                        "where p.created  > :fTime", Post.class).setParameter("fTime",
                        LocalDateTime.now().withHour(0).withMinute(0).withSecond(0)).list()
        );
    }

    public List<Post> findPostsWithPhotos() {
        return this.tx(
                session -> session.createQuery("select distinct p from Post p " +
                        "join fetch p.car c " +
                        "join fetch p.user u " +
                        "where p.photo is not null ", Post.class).list()
        );
    }

    public List<Post> findPostsWithBrand(int brandId) {
        return this.tx(
                session -> session.createQuery("select distinct p from Post p " +
                        "join fetch p.car c " +
                        "join fetch p.user u " +
                        "where c.id = :cBrandId", Post.class).setParameter("cBrandId", brandId).list()
        );
    }
}