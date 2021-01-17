package com.sda.tests;

import org.junit.jupiter.api.*;

class JunitMethods {

    @BeforeAll
    static void beforeAll() {
        System.out.println("only once");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("only once after");
    }

    @BeforeEach
    void setUp() {
        System.out.println("before each test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after each test");
    }

    @Test
    void test1() {
        System.out.println("in test 1");
    }

    @Test
    void test2() {
        System.out.println("in test 2");
    }
}
