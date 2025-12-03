package com.example.starsgallery.service;

import com.example.starsgallery.beans.Star;
import com.example.starsgallery.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class StarService implements IDao<Star> {

    private List<Star> stars;
    private static StarService instance;

    // Constructeur privé pour le singleton
    private StarService() {
        stars = new ArrayList<>();
        seed();
    }

    // Accès à l'instance unique
    public static StarService getInstance() {
        if (instance == null) {
            instance = new StarService();
        }
        return instance;
    }

    // Méthode pour pré-remplir quelques stars
    private void seed() {
        stars.add(new Star("Emma Watson", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFS5YSfaEIC0EK0jOTR0wKxhEOV77AcA4jQg&s", 4.5f));
        stars.add(new Star("Tom Cruise", "https://cdn.unitycms.io/images/4_cEBegzqv5A-mJ35uSPGS.jpg", 4.2f));
        stars.add(new Star("Scarlett Johansson", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfERngf8g_lDOAORTBgu9fTacanSYncWzRig&s", 4.7f));
        stars.add(new Star("Leonardo DiCaprio", "https://cdn.britannica.com/65/227665-050-D74A477E/American-actor-Leonardo-DiCaprio-2016.jpg", 4.8f));
    }

    // Méthode pour récupérer toutes les stars
    public List<Star> findAll() {
        return new ArrayList<>(stars); // renvoie une copie pour éviter les modifications directes
    }

    @Override
    public boolean create(Star o) {
        return stars.add(o);
    }

    @Override
    public boolean update(Star o) {
        for (Star s : stars) {
            if (s.getId() == o.getId()) {
                s.setName(o.getName());
                s.setImg(o.getImg());
                s.setRating(o.getRating());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Star o) {
        return stars.remove(o);
    }

    @Override
    public Star findById(int id) {
        for (Star s : stars) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
