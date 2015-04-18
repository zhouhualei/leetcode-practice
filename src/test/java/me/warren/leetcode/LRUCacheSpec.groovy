package me.warren.leetcode

import spock.lang.Specification


/**
 * Created by warzhou1 on 4/18/15.
 */
class LRUCacheSpec extends Specification {

    def "test Cache Simple Get and Set"() {
        setup: "a cache instace is created"
            def cache = new LRUCache(10)
        when:
            cache.set(2, 1)
        then:
            1 == cache.get(2)
        when:
            cache.set(3, 2)
        then:
            1 == cache.get(2)
            2 == cache.get(3)
    }

    void "test Cache Removal"() {
        setup: "a cache instace is created"
            def cache = new LRUCache(1);
        when:
            cache.set(2, 1);
        then:
            1 == cache.get(2);
        when:
            cache.set(3, 2);
        then:
            -1 == cache.get(2);
    }

}
