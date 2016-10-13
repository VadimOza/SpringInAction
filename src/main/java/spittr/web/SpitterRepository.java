package spittr.web;

import spittr.Spitter;

/**
 * Created by root on 12.10.16.
 */
public interface SpitterRepository {
    Spitter save(Spitter unsaved);

    Spitter findByUsername(String userName);
}
