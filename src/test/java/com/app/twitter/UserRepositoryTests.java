package com.app.twitter;
import static org.assertj.core.api.Assertions.assertThat;

import com.app.twitter.model.User;
import com.app.twitter.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("admin1@admin.com");
        user.setPassword("kiran");
        user.setFirstName("kiran");
        user.setLastName("babu");

        User savedUser = repo.save(user);

        User existedUser = entityManager.find(User.class, savedUser.getId());

        assertThat(existedUser.getEmail()).isEqualTo(user.getEmail());

    }

    @Test
    public void testFindUserByEmail() {
        String email = "kiraniiitn@gmail.com";

        User user = repo.findByEmail(email);

        assertThat(user).isNotNull();
    }


}
