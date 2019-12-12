package com.sectors.domain;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "sectors")
public class Sectors implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "sectorname", nullable = false)
    private String sectorName;

    @Column(name = "brief", nullable = false)
    private String brief;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
