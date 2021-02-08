package pl.pjatk.gameplay.player.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private int health;
    private int attack;
    private int mana;
    @OneToMany(mappedBy = "player",
    cascade = CascadeType.ALL)
    private List<Message> messageList = new ArrayList<>();

    public Player(Long id, String nickname, int health, int attack, int mana) {
        this.id = id;
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
    }

    public Player(String nickname, int health, int attack, int mana) {
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
    }

    public Player(String nickname, int health, int attack, int mana, List<Message> messageList) {
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
        this.messageList = messageList;
    }

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", mana=" + mana +
                ", messageList=" + messageList +
                '}';
    }
}
