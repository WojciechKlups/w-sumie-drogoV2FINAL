package pl.sda.wsumiedrogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.wsumiedrogo.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByUsername(String username);
}
