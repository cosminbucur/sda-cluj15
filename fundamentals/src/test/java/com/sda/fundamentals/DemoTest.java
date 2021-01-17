package com.sda.fundamentals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class DemoTest {

    @Test
    void given2and3_whenAddTwoNumbers_shouldReturn5() {
        // given
        Demo demo = new Demo();
        int expected = 5;

        // when
        int actual = demo.addTwoNumbers(2, 3);

        // then
        assertThat(actual).isEqualTo(expected);

        // junit assert
        // import org.junit.jupiter.api.Assertions;
//        Assertions.assertEquals(actual, expected);
    }
}
