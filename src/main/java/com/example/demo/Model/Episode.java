package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "episode")
public class Episode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name="episode_number")
    private int episode_number;

    @Column(name = "description")
    private String description;

    @Column(name ="release_date")
    private Date release_date;

    @Column(name = "duration")
    private Double duration;

    @Column (name = "video_url")
    private String video_url;

    @Column(name = "status")
    private Boolean status; //0 là xóa, 1 là hoạt động

    @Column(name ="created_at")
    private Date created_at;

}
