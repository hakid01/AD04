/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accesodatos.AD04.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author erifc
 */
@Entity
@Table(name = "stores")
public class Store implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int store_id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
    @Column(name = "town")
    private String town;

    public Store() {
    }

    public Store(String name, String town, Province province) {
        this.name = name;
        this.province = province;
        this.town = town;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "" + store_id + " - " + name + ", " + town + " (" + province.getNome() + ")";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.store_id;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.province);
        hash = 31 * hash + Objects.hashCode(this.town);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Store other = (Store) obj;
        if (this.store_id != other.store_id) {
            return false;
        }
        if(this.store_id == other.store_id){
        return true;
    }
        return true;
    }

    
    

    

}
