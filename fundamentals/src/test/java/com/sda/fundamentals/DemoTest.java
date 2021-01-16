package com.sda.fundamentals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DemoTest {

    @Test
    void test() {
        assertThat(this).isEqualTo(this);
    }
}