/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accesodatos.AD04.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hak
 */
@Entity
@Table(name = "item_store")
public class ItemStore implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @Id
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    @Column(name = "stock")
    private int stock;

    public ItemStore() {
    }

    public ItemStore(Store store, Item item, int stock) {
        this.store = store;
        this.item = item;
        this.stock = stock;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.store);
        hash = 17 * hash + Objects.hashCode(this.item);
        hash = 17 * hash + this.stock;
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
        final ItemStore other = (ItemStore) obj;
        if (!Objects.equals(this.store, other.store)) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        return true;
    }
    
    
    
}
