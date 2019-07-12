/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.project.lmb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Panos
 */
@Entity
@Table(name = "room_unavailability")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomUnavailability.findAll", query = "SELECT r FROM RoomUnavailability r")
    , @NamedQuery(name = "RoomUnavailability.findById", query = "SELECT r FROM RoomUnavailability r WHERE r.id = :id")
    , @NamedQuery(name = "RoomUnavailability.findByUserid", query = "SELECT r FROM RoomUnavailability r WHERE r.userid = :userid")
    , @NamedQuery(name = "RoomUnavailability.findByStartdate", query = "SELECT r FROM RoomUnavailability r WHERE r.startdate = :startdate")
    , @NamedQuery(name = "RoomUnavailability.findByEnddate", query = "SELECT r FROM RoomUnavailability r WHERE r.enddate = :enddate")
    , @NamedQuery(name = "RoomUnavailability.findByTotalcost", query = "SELECT r FROM RoomUnavailability r WHERE r.totalcost = :totalcost")})
public class RoomUnavailability implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "User_id")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Start_date")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "End_date")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Total_cost")
    private Float totalcost;
    @JoinColumn(name = "Hotel_id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Hotel hotelid;
    @JoinColumn(name = "Room_id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Room roomid;
    @JoinColumn(name = "Status", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public RoomUnavailability() {
    }

    public RoomUnavailability(Integer id) {
        this.id = id;
    }

    public RoomUnavailability(Integer id, Date startdate, Date enddate) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Float getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(Float totalcost) {
        this.totalcost = totalcost;
    }

    public Hotel getHotelid() {
        return hotelid;
    }

    public void setHotelid(Hotel hotelid) {
        this.hotelid = hotelid;
    }

    public Room getRoomid() {
        return roomid;
    }

    public void setRoomid(Room roomid) {
        this.roomid = roomid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomUnavailability)) {
            return false;
        }
        RoomUnavailability other = (RoomUnavailability) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bootcamp.project.lmb.model.RoomUnavailability[ id=" + id + " ]";
    }
    
}
