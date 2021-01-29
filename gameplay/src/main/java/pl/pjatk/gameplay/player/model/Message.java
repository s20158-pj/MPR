package pl.pjatk.gameplay.player.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonIgnore
    private Player player;

    public Message(String content, Player player) {
        this.content = content;
        this.player = player;
    }

    public Message() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
