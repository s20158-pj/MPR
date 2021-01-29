package pl.pjatk.gameplay.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.gameplay.player.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
