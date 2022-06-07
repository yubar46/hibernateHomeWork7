package repository;

import domain.User;

import java.util.List;

public interface UserRepository extends Repository<User,Integer> {

    List<User> selectAllUsers();





}
