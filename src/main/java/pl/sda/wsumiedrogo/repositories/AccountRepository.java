package pl.sda.wsumiedrogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.wsumiedrogo.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByUsername(String username);
}
