package spittr.web;

import spittr.Spittle;

import java.util.List;

/**
 * Created by root on 12.10.16.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long l, int i);

    Spittle findOne(long id);
}
