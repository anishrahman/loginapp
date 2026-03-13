<<<<<<< HEAD
package com.example.loginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.loginapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
=======
package com.example.loginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.loginapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
>>>>>>> b171f0efc6532b7443bc587e7966a2f9aaad96e2
