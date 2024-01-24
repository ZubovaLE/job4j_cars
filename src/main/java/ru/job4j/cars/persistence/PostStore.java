package ru.job4j.cars.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.cars.model.Post;

import java.util.List;

public class PostStore extends AbstractStore<Post>{

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

    public List<Post> findNewPosts() {
        return this.tx(
                session -> session
                        .createQuery("select distinct i from Post i inner join fetch i.car c " +
                                "where i.created >= date_trunc('DAY', current_date)").list()
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
}