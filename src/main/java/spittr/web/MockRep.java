package spittr.web;

import org.springframework.stereotype.Component;
import spittr.Spitter;
import spittr.Spittle;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by root on 13.10.16.
 */

@Component
public class MockRep implements SpitterRepository {

    private ConcurrentLinkedQueue<Spitter> allSpitters = new ConcurrentLinkedQueue<>();

    @Override
    public Spitter save(Spitter unsaved) {
        allSpitters.add(unsaved);
        return unsaved;
    }

    @Override
    public Spitter findByUsername(String userName) {
        for (Spitter s :
                allSpitters) {
            if (s.getUserName().equals(userName))
                    return s;
        }
        return null;
    }
}
