package repository;

public interface Repository<T,ID> {


    void create(T t);
    T select(ID id);
    T Update(T t);
    void delete(T t);



}
