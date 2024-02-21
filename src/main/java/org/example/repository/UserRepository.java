package org.example.repository;

import org.example.entity.UserDO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserDO, UUID> {
    UserDO findByUserName(String userName);
}
