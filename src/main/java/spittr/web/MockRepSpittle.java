package spittr.web;

import org.springframework.stereotype.Component;
import spittr.Spitter;
import spittr.Spittle;

import java.util.List;

/**
 * Created by root on 13.10.16.
 */

@Component
public class MockRepSpittle implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long l, int i) {
        return null;
    }

    @Override
    public Spittle findOne(long id) {
        return null;
    }
}
