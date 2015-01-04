package com.ibm;

import javax.annotation.Resource;
import javax.inject.Inject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ibm.beans.Party;
import com.ibm.beans.impl.Organization;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class AppTest

{
    @Resource(name="organization")
    private Party resource;

    @Inject
    @Qualifier("organization")
    private Party test;

    @Before
    public void init() {
        System.out.println("initialisation des variables");
    }

    @Test
    public void asynchronousT1() {

        boolean test1 = resource instanceof Organization;
        boolean test2 = test instanceof Organization;
        System.out.println("test asynchronous 1  :"+Boolean.valueOf(test1));
        System.out.println("test asynchronous 2  :"+Boolean.valueOf(test2));

    }

    @After
    public void end() {
        System.out.println("Nettoyage des ressoures");
    }
}
